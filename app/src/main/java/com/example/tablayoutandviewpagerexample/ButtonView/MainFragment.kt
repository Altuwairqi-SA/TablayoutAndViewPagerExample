package com.example.tablayoutandviewpagerexample.ButtonView

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import com.example.tablayoutandviewpagerexample.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val numberOfTabs = 3

        // make text and icon of tab in the same line
        tab_layout.isInlineLabel = true

        // Set the ViewPager Adapter
        val adapter = TabsPagerAdapter(requireFragmentManager(), lifecycle, numberOfTabs)
        tabs_viewpager.adapter = adapter

        // Enable Swipe, (default is true)
       tabs_viewpager.isUserInputEnabled = true

        // Link the TabLayout and the ViewPager2 together and Set Text & Icons
        TabLayoutMediator(tab_layout, tabs_viewpager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Music"
                    tab.setIcon(R.drawable.ic_music)
                }
                1 -> {
                    tab.text = "Movies"
                    tab.setIcon(R.drawable.ic_movie)

                }
                2 -> {
                    tab.text = "Books"
                    tab.setIcon(R.drawable.ic_book)
                }
            }
        }.attach()
    }
}