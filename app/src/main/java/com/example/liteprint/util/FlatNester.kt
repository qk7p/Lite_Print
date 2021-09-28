package com.example.liteprint.util

import com.example.liteprint.model.Detail
import com.example.liteprint.model.FlatMaterial
import kotlin.math.max
import kotlin.math.min

class FlatNester(
    detail: Detail, flatMaterial: FlatMaterial
) {

    private var detailWidth = max(detail._width + detail._margin, detail._height + detail._margin)
    private var detailHeight = min(detail._height + detail._margin, detail._width + detail._margin)
    private var materialWidth = max(flatMaterial._width - flatMaterial._margin, flatMaterial._height - flatMaterial._margin)
    private var materialHeight = min(flatMaterial._height - flatMaterial._margin, flatMaterial._width - flatMaterial._margin)

    fun nest(): Int {
        return max(nestByWidth(), nestByHeight())
    }


    private fun nestByWidth(): Int {
        val firstResult = (materialWidth / detailWidth) * (materialHeight / detailHeight)
        val usedWidth = detailWidth * (materialWidth / detailWidth)
        val freeWidth = materialWidth - usedWidth
        if (freeWidth >= detailHeight) {
            val secondResult = simpleNest(freeWidth, materialHeight)
            return firstResult + secondResult
        } else return firstResult
    }

    private fun nestByHeight(): Int {
        val firstResult = (materialWidth / detailHeight) * (materialHeight / detailWidth)
        val usedHeight = detailWidth * (materialHeight / detailWidth)
        val freeHeight = materialHeight - usedHeight
        if (freeHeight >= detailWidth) {
            val secondResult = simpleNest(materialWidth, freeHeight)
            return firstResult + secondResult
        } else return firstResult
    }

    private fun simpleNest(newMaterialWidth: Int, newMaterialHeight: Int): Int {
        return max(
            ((newMaterialWidth / detailHeight) * (newMaterialHeight / detailWidth)),
            ((newMaterialWidth / detailHeight) * (newMaterialHeight / detailWidth))
        )
    }
}