package com.example.marvel.domain.mapper


import com.example.marvel.data.remote.respons.SeriesDto
import com.example.marvel.domain.model.Item

class SerierDtoToObjectMapper: Mapper<SeriesDto, Item> {
    override fun map(input: SeriesDto): Item {
        return Item(
            id = input.id ?: 0,
            name = input.title ?: "",
            imgUrl = "${input.thumbnail?.path}.${input.thumbnail?.extension}",
        )
    }
}