package sk.sandeep.animeapp.ui.screens.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import dagger.hilt.android.AndroidEntryPoint
import sk.sandeep.animeapp.ui.screens.view_model.AnimeViewModel
import sk.sandeep.animeapp.ui.theme.AnimeAppTheme

@AndroidEntryPoint
class AnimeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                AnimeAppTheme {
                    AnimeScreen()
                }
            }
        }
    }
}

@Composable
fun AnimeScreen(viewModel: AnimeViewModel = hiltViewModel()) {

    val animeList = viewModel.topAnimeList.value

    Scaffold(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxSize()) {
            animeList.anime.let { anime ->
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(20.dp)
                ) {
                    items(anime) {
                        Card {
                            Column {
                                Image(
                                    painter = rememberAsyncImagePainter(it.images.jpg.imageUrl),
                                    contentDescription = "",
                                    modifier = Modifier.height(100.dp).width(100.dp)
                                )
                                Text(text = it.title)
                                Text(text = it.rating)
                                Spacer(modifier = Modifier.height(5.dp))
                            }
                        }
                    }
                }
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
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center), color = Color.Cyan)
            }
        }
    }
}