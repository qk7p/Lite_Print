package com.example.liteprint.model

class Detail (width: Int, height: Int, margin: Int) {
    val _width = width + margin
    val _height = height + margin
    val _margin = margin

    val detailArea = _width.toDouble() * _height.toDouble() / 1000000

}

