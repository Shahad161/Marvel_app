package com.example.marvel.domain.mapper

import com.example.marvel.data.local.entity.ComicsEntity
import com.example.marvel.data.remote.respons.comics.ComicsDto
import com.example.marvel.domain.model.Comics

class ComicsEntityMapper:Mapper<ComicsDto, ComicsEntity> {
    override fun map(input: ComicsDto): ComicsEntity {
        return ComicsEntity(
            id = input.id?.toLong() ?: 0L,
            name = input.title ?: "",
            imgUrl = "${input.thumbnail?.path}.${input.thumbnail?.extension}",
            modified = input.modified ?: "",
            pageCount = input.pageCount ?: 0,
            description =input.description ?: "",
        )
    }

}