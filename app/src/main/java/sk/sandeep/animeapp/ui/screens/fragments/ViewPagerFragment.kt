package sk.sandeep.animeapp.ui.screens.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import sk.sandeep.animeapp.R
import sk.sandeep.animeapp.databinding.FragmentViewPagerBinding
import sk.sandeep.animeapp.adapter.AnimeViewPagerAdapter
import sk.sandeep.animeapp.util.Constants.MY_ANIME_PAGE_INDEX
import sk.sandeep.animeapp.util.Constants.MY_MANGA_PAGE_INDEX

class ViewPagerFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        val tabLayout = binding.tabs
        val viewPager = binding.viewPager

        viewPager.adapter = AnimeViewPagerAdapter(this)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.setIcon(getTabIcon(position))
            tab.text = getTabTitle(position)
        }.attach()

        /* Set a Toolbar to act as the ActionBar for this Activity window. */
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)

        return binding.root
    }

    private fun getTabIcon(position: Int): Int {
        return when (position) {
            MY_ANIME_PAGE_INDEX -> R.drawable.ic_anime_video
            MY_MANGA_PAGE_INDEX -> R.drawable.ic_manga_book
            else -> throw IndexOutOfBoundsException()
        }
    }

    private fun getTabTitle(position: Int): String? {
        return when (position) {
            MY_ANIME_PAGE_INDEX -> getString(R.string.anime)
            MY_MANGA_PAGE_INDEX -> getString(R.string.manga)
            else -> null
        }
    }
}