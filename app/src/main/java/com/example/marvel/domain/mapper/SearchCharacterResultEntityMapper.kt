package com.example.marvel.domain.mapper

import com.example.marvel.data.local.entity.SearchCharacterResultEntity
import com.example.marvel.data.remote.respons.CharacterDto

class SearchCharacterResultEntityMapper:Mapper<CharacterDto, SearchCharacterResultEntity> {
    override fun map(input: CharacterDto): SearchCharacterResultEntity {
        return SearchCharacterResultEntity(
            id = input.id?.toLong() ?: 0L,
            name = input.name ?: "",
            description = input.description ?: "",
            modified = input.modified ?: "",
            imgUrl = "${input.thumbnail?.path}.${input.thumbnail?.extension}"
        )
    }
}