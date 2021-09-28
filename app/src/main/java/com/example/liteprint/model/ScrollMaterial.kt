package com.example.liteprint.model

class ScrollMaterial(_width: Int) {
    val width = _width

    fun getScrollMaterial(): String {
        return "рулон ${width.toDouble() / 1000} м"
    }

}