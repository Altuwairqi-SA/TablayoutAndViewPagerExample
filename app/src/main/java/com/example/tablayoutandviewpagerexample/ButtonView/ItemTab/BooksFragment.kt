package com.example.tablayoutandviewpagerexample.ButtonView.ItemTab

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tablayoutandviewpagerexample.R
import kotlinx.android.synthetic.main.fragment_books.view.*

class BooksFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_books, container, false)

        val fragmentName = arguments?.getString("fragmentName")

        rootView.fragment_name1.text = getString(R.string.book)
        Log.e(ContentValues.TAG, "onCreateView: $fragmentName")
        return rootView
    }
}