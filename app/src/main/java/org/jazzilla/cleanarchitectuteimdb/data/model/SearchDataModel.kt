package org.jazzilla.cleanarchitectuteimdb.data.model

import com.fasterxml.jackson.annotation.JsonAlias


data class SearchDataModel(
    @JsonAlias("Search")
    val search: List<SearchResultDataModel>)

data class SearchResultDataModel(
    val id: String,
    val name: String)

