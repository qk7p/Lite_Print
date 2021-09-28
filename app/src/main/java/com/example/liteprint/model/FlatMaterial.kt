package com.example.liteprint.model

class FlatMaterial (width: Int, height: Int, margin: Int) {
    val _width = width
    val _height = height
    var _margin = margin


    fun getMaterial() : String {
        return _width.toString() + "x" + _height.toString() + " мм"
    }

    fun changeMaterialMargin (margin: Int) {
        _margin = margin
    }

}