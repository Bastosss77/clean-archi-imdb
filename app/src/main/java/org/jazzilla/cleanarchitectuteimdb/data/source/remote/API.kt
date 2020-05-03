package org.jazzilla.cleanarchitectuteimdb.data.source.remote

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.jazzilla.cleanarchitectuteimdb.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.reflect.KClass

object API {
    private val retrofit : Retrofit
    private val imdbUrl = "https://www.omdbapi.com"

    init {
        val logInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

        val keyInterceptor = Interceptor {
            var request = it.request()
            val url = request.url.newBuilder().addQueryParameter("apikey", BuildConfig.IMDB_key).build()
            request = request.newBuilder().url(url).build()

            it.proceed(request)
        }

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logInterceptor)
            .addInterceptor(keyInterceptor)
            .build()

        retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(imdbUrl)
            .build()
    }

    fun <T : Any> client(clazz: KClass<T>) : T = retrofit.create(clazz.java)
}