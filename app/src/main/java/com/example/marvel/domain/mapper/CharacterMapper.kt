package com.example.marvel.domain.mapper

import com.example.marvel.data.remote.respons.CharacterDto
import com.example.marvel.domain.model.Characters

class CharacterMapper: Mapper<CharacterDto, Characters> {
    override fun map(input: CharacterDto): Characters {
        return Characters(
            id = input.id,
            name = input.name,
            imgUrl = "${input.thumbnail?.path}.${input.thumbnail?.extension}"
        )
    }
}