package org.jazzilla.cleanarchitectuteimdb.data.model

import com.google.gson.annotations.SerializedName


data class SearchDataModel(
    @SerializedName("Search")
    val search: List<SearchResultDataModel>)

data class SearchResultDataModel(
    val imdbID: String,

    @SerializedName("Title")
    val title: String)

