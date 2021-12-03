package com.example.marvel.domain.mapper

import com.example.marvel.data.local.entity.SearchCharacterResultEntity
import com.example.marvel.domain.model.Characters

class SearchCharacterResultMapper: Mapper<SearchCharacterResultEntity, Characters>{
    override fun map(input: SearchCharacterResultEntity): Characters{
        return Characters(
            id = input.id.toInt(),
            name = input.name,
            imgUrl = input.imgUrl
        )
    }

}