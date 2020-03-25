package org.jazzilla.cleanarchitectuteimdb.presentation.search

import org.jazzilla.cleanarchitectuteimdb.R
import org.jazzilla.cleanarchitectuteimdb.databinding.FragmentSearchBinding
import org.jazzilla.cleanarchitectuteimdb.presentation.common.BaseFragment

class SearchFragment : BaseFragment(R.layout.fragment_search) {
    private lateinit var thisBinding: FragmentSearchBinding

    override fun viewCreated() {
        thisBinding = dataBinding as FragmentSearchBinding
    }
}