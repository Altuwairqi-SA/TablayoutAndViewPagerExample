package com.example.tablayoutandviewpagerexample.ButtonView

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tablayoutandviewpagerexample.ButtonView.ItemTab.BooksFragment
import com.example.tablayoutandviewpagerexample.ButtonView.ItemTab.MoviesFragment
import com.example.tablayoutandviewpagerexample.ButtonView.ItemTab.MusicFragment

class TabsPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle, private var numberOfTabs: Int) : FragmentStateAdapter(fm, lifecycle) {

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> {
                // # Music Fragment
                val bundle = Bundle()
                bundle.putString("fragmentName", "Music Fragment")
                val musicFragment = MusicFragment()
                musicFragment.arguments = bundle
                Log.e(TAG, "musicFragment: $bundle" )
                return musicFragment
            }
            1 -> {
                // # Movies Fragment
                val bundle = Bundle()
                bundle.putString("fragmentName", "Movies Fragment")
                val moviesFragment = MoviesFragment()
                moviesFragment.arguments = bundle
                Log.e(TAG, "moviesFragment: $bundle" )
                return moviesFragment
            }
            2 -> {
                // # Books Fragment
                val bundle = Bundle()
                bundle.putString("fragmentName", "Books Fragment")
                val booksFragment = BooksFragment()
                booksFragment.arguments = bundle
                Log.e(TAG, "booksFragment: $bundle" )
                return booksFragment
            }
            else -> return BooksFragment()
        }
    }

    override fun getItemCount(): Int {
        return numberOfTabs
    }
}