package com.example.marvel.domain.mapper

import com.example.marvel.data.local.entity.CharactersEntity
import com.example.marvel.data.remote.respons.CharacterDto


class CharacterEntityMapper:Mapper<CharacterDto, CharactersEntity> {
    override fun map(input: CharacterDto): CharactersEntity {
        return CharactersEntity(
            id = input.id?.toLong() ?: 0L,
            name = input.name ?: "",
            description = input.description ?: "",
            modified = input.modified ?: "",
            imgUrl = "${input.thumbnail?.path}.${input.thumbnail?.extension}"
        )
    }
}
