package org.jazzilla.cleanarchitectuteimdb.domain.usecase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

abstract class UseCase<in Params, out Type> {
    operator fun invoke(params: Params) : Flow<Type> = flow {
        emit(run(params))
    }.flowOn(Dispatchers.IO)

    abstract suspend fun run(params: Params) : Type
}