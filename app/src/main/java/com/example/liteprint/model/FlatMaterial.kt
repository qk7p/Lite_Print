package com.example.liteprint.model

class FlatMaterial (width: Int, height: Int, margin: Int) {
    val _width = width
    val _height = height
    var _margin = margin

    val materialArea = _width.toDouble() * _height.toDouble() / 1000000


    fun getMaterial() : String {
        return _width.toString() + "x" + _height.toString() + " мм"
    }

    fun changeMaterialMargin (margin: Int) {
        _margin = margin
    }

    fun getMaterialAreaString () : String {
       return String.format("%.3f", materialArea)
    }

}