package com.example.marvel.domain.mapper

import com.example.marvel.data.local.entity.ComicsEntity
import com.example.marvel.domain.model.Comics

class ComicsMapper:Mapper<ComicsEntity, Comics> {
    override fun map(input: ComicsEntity): Comics {
        return Comics(
            id = input.id.toInt(),
            name = input.name ,
            imgUrl = input.imgUrl,
            pageCount = input.pageCount,
            description = input.description,
        )
    }
}