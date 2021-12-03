package com.example.marvel.domain.mapper

import com.example.marvel.data.local.entity.StoriesEntity
import com.example.marvel.data.remote.respons.StoriesDto

class StoriesEntityMapper:Mapper<StoriesDto, StoriesEntity> {
    override fun map(input: StoriesDto): StoriesEntity {
        return StoriesEntity(
            id = input.id?.toLong() ?: 0L,
            name = input.title ?: "",
            modified = input.modified ?:"",
            imgUrl = "${input.thumbnail?.path}.${input.thumbnail?.extension}",
            type = input.type ?:"",
            description = input.description ?:""
        )
    }
}