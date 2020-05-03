package org.jazzilla.cleanarchitectuteimdb.domain.converter

import org.jazzilla.cleanarchitectuteimdb.data.model.SearchDataModel
import org.jazzilla.cleanarchitectuteimdb.data.model.SearchResultDataModel
import org.jazzilla.cleanarchitectuteimdb.domain.model.SearchDomainModel

class SearchConverter {

    companion object {

        fun dataToDomainResultList(dataModel: SearchDataModel) : List<SearchDomainModel> =
            dataModel.search.map { dataToDomain(it) }

        fun dataToDomain(dataModel: SearchResultDataModel) : SearchDomainModel =
            SearchDomainModel(dataModel.imdbID, dataModel.title)
    }
}