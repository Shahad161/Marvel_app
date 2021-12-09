package com.example.marvel.domain.mapper

import com.example.marvel.data.remote.respons.comics.ComicsDto
import com.example.marvel.domain.model.Item

class ComicsDtoToObjectMapper: Mapper<ComicsDto, Item> {
    override fun map(input: ComicsDto): Item {
        return Item(
            id = input.id ?: 0,
            name = input.title ?: "",
            imgUrl = "${input.thumbnail?.path}.${input.thumbnail?.extension}",
        )
    }
}