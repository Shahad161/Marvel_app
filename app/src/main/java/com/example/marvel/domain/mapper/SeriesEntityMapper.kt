package com.example.marvel.domain.mapper

import com.example.marvel.data.local.entity.SeriesEntity
import com.example.marvel.data.remote.respons.SeriesDto

class SeriesEntityMapper:Mapper<SeriesDto, SeriesEntity> {
    override fun map(input: SeriesDto): SeriesEntity {
        return SeriesEntity(
            id = input.id?.toLong() ?: 0L,
            description = input.description ?: "",
            endYear = input.endYear ?: 0,
            modified = input.modified ?: "",
            rating = input.rating ?: "",
            startYear = input.startYear ?: 0,
            name = input.title ?: "",
            type = input.type ?: "",
            imgUrl = "${input.thumbnail?.path}.${input.thumbnail?.extension}",

            )
    }
}