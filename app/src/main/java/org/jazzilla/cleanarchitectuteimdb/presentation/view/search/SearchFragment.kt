package org.jazzilla.cleanarchitectuteimdb.presentation.view.search

import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import org.jazzilla.cleanarchitectuteimdb.R
import org.jazzilla.cleanarchitectuteimdb.databinding.FragmentSearchBinding
import org.jazzilla.cleanarchitectuteimdb.domain.model.SearchDomainModel
import org.jazzilla.cleanarchitectuteimdb.presentation.common.BaseFragment
import org.jazzilla.cleanarchitectuteimdb.presentation.extension.observe
import org.koin.android.viewmodel.ext.android.viewModel

class SearchFragment : BaseFragment(R.layout.fragment_search) {
    private lateinit var thisBinding: FragmentSearchBinding
    private val searchViewModel : SearchViewModel by viewModel()
    private val searchResultAdapter = SearchResultAdapter()

    @ExperimentalCoroutinesApi
    @InternalCoroutinesApi
    override fun viewCreated() {
        thisBinding = dataBinding as FragmentSearchBinding

        with(thisBinding.searchResults) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = searchResultAdapter
            setHasFixedSize(false)
        }

        observe(searchViewModel.results) {
            when(it) {
                is Either.Success -> showResults(it.data)
                is Either.Failure -> showError()
            }
        }

        with(thisBinding.search) {
            setOnEditorActionListener { _, action, _ ->
                if(action == EditorInfo.IME_ACTION_SEARCH) {
                    makeSearch(text.toString())

                    return@setOnEditorActionListener true
                }

                return@setOnEditorActionListener false
            }
        }
    }

    @ExperimentalCoroutinesApi
    @InternalCoroutinesApi
    private fun makeSearch(term: String) {
        thisBinding.loader.visibility = View.VISIBLE
        searchViewModel.search(term)
    }

    private fun showResults(results: List<SearchDomainModel>) {
        thisBinding.loader.visibility = View.GONE
        searchResultAdapter.setItems(results)
    }

    private fun showError() {
        context?.let {
            Toast.makeText(it, "Something wrong appear", Toast.LENGTH_SHORT).show()
        }
    }
}