package org.jazzilla.cleanarchitectuteimdb.data.source.remote

import org.jazzilla.cleanarchitectuteimdb.data.model.SearchDataModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchClient {

    @GET("./")
    suspend fun search(@Query("s") term: String) : Response<SearchDataModel>
}