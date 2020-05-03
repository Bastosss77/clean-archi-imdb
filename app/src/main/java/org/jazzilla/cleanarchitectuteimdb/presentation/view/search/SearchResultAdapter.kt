package org.jazzilla.cleanarchitectuteimdb.presentation.view.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import org.jazzilla.cleanarchitectuteimdb.R
import org.jazzilla.cleanarchitectuteimdb.databinding.SearchResultItemBinding
import org.jazzilla.cleanarchitectuteimdb.domain.model.SearchDomainModel

typealias ItemClick = (SearchDomainModel) -> Unit

class SearchResultAdapter(private var items : List<SearchDomainModel> = emptyList(),
                          inline val onItemClick: ItemClick = {}) : RecyclerView.Adapter<SearchResultAdapter.SearchResultViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultViewHolder {
        val binding = DataBindingUtil.inflate<SearchResultItemBinding>(LayoutInflater.from(parent.context), R.layout.search_result_item, parent, false)

        return SearchResultViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchResultViewHolder, position: Int) {
        holder.bind(items[position], onItemClick)
    }

    override fun getItemCount(): Int = items.size

    fun setItems(items: List<SearchDomainModel>) {
        this.items = items
        notifyDataSetChanged()
    }

    inner class SearchResultViewHolder(private val binding: SearchResultItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: SearchDomainModel, click: ItemClick) {
            itemView.setOnClickListener { click(item) }
            binding.result = item
        }
    }
}