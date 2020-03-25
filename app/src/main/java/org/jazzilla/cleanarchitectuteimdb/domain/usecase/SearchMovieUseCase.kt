package org.jazzilla.cleanarchitectuteimdb.domain.usecase

import org.jazzilla.cleanarchitectuteimdb.data.model.Movie
import org.jazzilla.cleanarchitectuteimdb.data.repository.MovieRepository

class SearchMovieUseCase(private val movieRepository: MovieRepository) : UseCase<SearchMovieUseCase.SearchParams, List<Movie>>() {

    override suspend fun run(params: SearchParams): List<Movie> {

    }

    class SearchParams
}