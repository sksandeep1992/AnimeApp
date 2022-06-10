package sk.sandeep.animeapp.ui.screens.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import dagger.hilt.android.AndroidEntryPoint
import sk.sandeep.animeapp.R
import sk.sandeep.animeapp.databinding.FragmentMangaBinding
import sk.sandeep.animeapp.ui.screens.view_model.MangaViewModel
import sk.sandeep.animeapp.ui.theme.AnimeAppTheme

@AndroidEntryPoint
class MangaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = DataBindingUtil.inflate<FragmentMangaBinding>(
            inflater, R.layout.fragment_manga, container, false
        ).apply {
            composeView.setContent {
                AnimeAppTheme {
                    Scaffold(modifier = Modifier.fillMaxSize()) {
                        MangaScreen()
                    }
                }
            }
        }
        return binding.root
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MangaScreen(viewModel: MangaViewModel = hiltViewModel()) {
    val animeList = viewModel.topMangaList.value
    Box(modifier = Modifier.fillMaxWidth()) {
        animeList.manga.let { manga ->
            LazyVerticalGrid(
                contentPadding = PaddingValues(
                    top = 10.dp,
                    start = 10.dp,
                    end = 10.dp,
                    bottom = 50.dp
                ),
                cells = GridCells.Adaptive(150.dp),
                content = {
                    items(manga) {
                        Card(
                            modifier = Modifier
                                .padding(10.dp)
                                .width(150.dp)
                                .height(150.dp),
                        ) {
                            Column {
                                Image(
                                    painter = rememberAsyncImagePainter(it.images.jpg.largeImageUrl),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .fillMaxHeight(0.7f),
                                    contentScale = ContentScale.FillHeight
                                )
                                Text(
                                    text = it.title,
                                    overflow = TextOverflow.Ellipsis,
                                    maxLines = 1,
                                    modifier = Modifier.padding(horizontal = 2.dp)
                                )
                                Text(
                                    text = "Episodes : ${it.chapters}",
                                    overflow = TextOverflow.Ellipsis,
                                    maxLines = 1,
                                    modifier = Modifier.padding(horizontal = 2.dp)
                                )
                            }
                        }
                    }
                }
            )
        }
        if (animeList.error.isNotBlank()) {
            Text(
                text = animeList.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (animeList.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = Color.Cyan
            )
        }
    }
}
