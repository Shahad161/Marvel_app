package com.example.marvel.domain.mapper

import com.example.marvel.data.local.entity.ComicsEntity
import com.example.marvel.data.remote.respons.comics.ComicsDto
import com.example.marvel.domain.model.Comics

class ComicsMapper:Mapper<ComicsDto, ComicsEntity> {


    override fun map(input: ComicsDto): ComicsEntity {
        return ComicsEntity(
            id = input.id?.toLong() ?: 0L,
            title = input.title ?: "",
            imgUrl = "${input.thumbnail?.path}.${input.thumbnail?.extension}",
            modified = input.modified ?: "",
            pageCount = input.pageCount ?: 0,
            description =input.description ?: "",
        )
    }

}

class ComicsObjectMapper:Mapper<ComicsEntity, Comics> {
    override fun map(input: ComicsEntity): Comics {
        return Comics(
            id = input.id.toInt(),
            title = input.title ,
            imgUrl = input.imgUrl,
            modified = input.modified,
            pageCount = input.pageCount,
            description =input.description,
        )
    }

}