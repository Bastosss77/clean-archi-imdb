package org.jazzilla.cleanarchitectuteimdb.presentation.view.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.jazzilla.cleanarchitectuteimdb.domain.model.SearchDomainModel
import org.jazzilla.cleanarchitectuteimdb.domain.usecase.SearchMovieUseCase

class SearchViewModel(private val searchMovieUseCase: SearchMovieUseCase) : ViewModel() {
    val results : MutableLiveData<Either<List<SearchDomainModel>, Throwable>> = MutableLiveData()

    @ExperimentalCoroutinesApi
    @InternalCoroutinesApi
    fun search(term: String) {
        viewModelScope.launch {
            searchMovieUseCase(SearchMovieUseCase.SearchParams(term))
                .catch { exception ->
                    results.postValue(Either.Failure(exception))
                }.collect {
                    results.postValue(Either.Success(it))
                }

        }
    }
}

sealed class Either<out R, out T> {
    data class Success<out R>(val data: R) : Either<R, Nothing>()
    data class Failure<out T : Throwable>(val error: T) : Either<Nothing, T>()
}