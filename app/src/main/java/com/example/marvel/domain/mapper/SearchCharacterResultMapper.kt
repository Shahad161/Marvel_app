package com.example.marvel.domain.mapper

import com.example.marvel.data.local.entity.SearchCharacterResultEntity
import com.example.marvel.domain.model.SearchCharacterResult

class SearchCharacterResultMapper: Mapper<SearchCharacterResultEntity, SearchCharacterResult>{
    override fun map(input: SearchCharacterResultEntity): SearchCharacterResult{
        return SearchCharacterResult(
            id = input.id.toInt(),
            name = input.name,
            imgUrl = input.imgUrl
        )
    }

}