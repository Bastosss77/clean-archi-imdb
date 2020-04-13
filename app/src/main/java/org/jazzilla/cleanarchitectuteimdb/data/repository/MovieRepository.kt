package org.jazzilla.cleanarchitectuteimdb.data.repository

import org.jazzilla.cleanarchitectuteimdb.data.model.SearchDataModel
import org.jazzilla.cleanarchitectuteimdb.data.source.remote.API
import org.jazzilla.cleanarchitectuteimdb.data.source.remote.SearchClient

interface MovieRepository {
    suspend fun search(term: String) : SearchDataModel
}

class MovieRepositoryImpl : MovieRepository {
    private val movieType = "movie"

    override suspend fun search(term: String): SearchDataModel {
        val client = API.client(SearchClient::class)

        return client.search(movieType, term).body() ?: throw Exception("Response is null")
    }
}