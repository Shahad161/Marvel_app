package com.example.marvel.domain.mapper

import com.example.marvel.data.local.entity.SeriesEntity
import com.example.marvel.domain.model.Series

class SeriesMapper: Mapper<SeriesEntity, Series> {
    override fun map(input: SeriesEntity): Series {
        return Series(
            id = input.id.toInt(),
            endYear = input.endYear,
            rating = input.rating,
            startYear = input.startYear,
            name = input.name,
            type = input.type,
            imgUrl = input.imgUrl
        )
    }
}