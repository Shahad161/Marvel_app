package com.example.marvel.domain.mapper

import com.example.marvel.data.local.entity.CharactersEntity
import com.example.marvel.domain.model.Characters


class CharacterMapper: Mapper<CharactersEntity, Characters> {
    override fun map(input: CharactersEntity): Characters {
        return Characters(
            id = input.id.toInt(),
            name = input.name,
            imgUrl = input.imgUrl
        )
    }

}