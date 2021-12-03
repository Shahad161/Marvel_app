package com.example.marvel.domain.mapper

import com.example.marvel.data.local.entity.StoriesEntity
import com.example.marvel.domain.model.Stories

class StoriesMapper: Mapper<StoriesEntity, Stories> {
    override fun map(input: StoriesEntity): Stories {
        return Stories(
            id = input.id.toInt(),
            name = input.name,
            imgUrl = input.imgUrl
        )
    }
}
