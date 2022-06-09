package sk.sandeep.animeapp.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import sk.sandeep.animeapp.ui.screens.fragments.AnimeFragment
import sk.sandeep.animeapp.ui.screens.fragments.MangaFragment
import sk.sandeep.animeapp.util.Constants.MY_ANIME_PAGE_INDEX
import sk.sandeep.animeapp.util.Constants.MY_MANGA_PAGE_INDEX

class AnimeViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    /**
     * Mapping of the ViewPager page indexes to their respective Fragments
     */
    private val tabFragments: Map<Int, () -> Fragment> = mapOf(
        MY_ANIME_PAGE_INDEX to { AnimeFragment() },
        MY_MANGA_PAGE_INDEX to { MangaFragment() }
    )

    override fun getItemCount(): Int {
        return tabFragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return tabFragments[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}