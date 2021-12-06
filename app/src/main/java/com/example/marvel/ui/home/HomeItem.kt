package com.example.marvel.ui.home

import com.example.marvel.domain.model.*


sealed class HomeItem(val rank: Int) {
    class SliderType(val items: List<Characters>) : HomeItem(0)
    class CharacterType(val items: List<Characters>) : HomeItem(1)
    class ComicsType(val items: List<Comics>) : HomeItem(2)
    class SeriesType(val items: List<Series>) : HomeItem(3)
}