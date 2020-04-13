package org.jazzilla.cleanarchitectuteimdb

import android.app.Application
import org.jazzilla.cleanarchitectuteimdb.data.repository.MovieRepository
import org.jazzilla.cleanarchitectuteimdb.data.repository.MovieRepositoryImpl
import org.jazzilla.cleanarchitectuteimdb.domain.usecase.SearchMovieUseCase
import org.jazzilla.cleanarchitectuteimdb.presentation.search.SearchViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import timber.log.Timber

class CleanArchiApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        setupKoin()
        setupTimber()
    }

    private fun setupKoin() {
        val appModules = module {
            //Repositories
            single<MovieRepository> { MovieRepositoryImpl() }

            //UseCases
            single { SearchMovieUseCase(get()) }

            //ViewModels
            viewModel { SearchViewModel(get()) }
        }

        startKoin {
            androidLogger()
            androidContext(this@CleanArchiApplication)
            modules(appModules)
        }
    }

    private fun setupTimber() {
        Timber.plant(Timber.DebugTree())
    }
}