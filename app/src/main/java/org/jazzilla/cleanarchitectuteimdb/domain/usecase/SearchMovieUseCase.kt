package org.jazzilla.cleanarchitectuteimdb.domain.usecase

import org.jazzilla.cleanarchitectuteimdb.data.repository.MovieRepository
import org.jazzilla.cleanarchitectuteimdb.domain.converter.SearchConverter
import org.jazzilla.cleanarchitectuteimdb.domain.model.SearchDomainModel

class SearchMovieUseCase(private val movieRepository: MovieRepository) : UseCase<SearchMovieUseCase.SearchParams, List<SearchDomainModel>>() {

    override suspend fun run(params: SearchParams): List<SearchDomainModel> {
        val results = movieRepository.search(params.term)

        return SearchConverter.dataToDomainResultList(results)
    }

    class SearchParams(val term: String)
}