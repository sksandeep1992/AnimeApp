package sk.sandeep.animeapp.ui.screens.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import sk.sandeep.animeapp.data.remote.AnimeApi
import sk.sandeep.animeapp.databinding.FragmentAnimeBinding
import sk.sandeep.animeapp.repository.AnimeRepository
import sk.sandeep.animeapp.view_model.AnimeViewModel
import sk.sandeep.animeapp.view_model.AnimeViewModelFactory

class AnimeFragment : Fragment() {


        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentAnimeBinding.inflate(inflater, container, false)

            val respositery =AnimeRepository()

            val  viewModelProvider =AnimeViewModelFactory(respositery)
            // viewmodel initialization
            val viewModel = ViewModelProvider(this,viewModelProvider).get(AnimeViewModel::class.java)

            viewModel.topAnimeList.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
                    binding.textView.text =it.data!!.data[0].title
            })

        return binding.root
    }
}