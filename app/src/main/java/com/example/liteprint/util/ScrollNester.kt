package com.example.liteprint.util

import com.example.liteprint.model.Detail
import com.example.liteprint.model.ScrollMaterial
import kotlin.math.max
import kotlin.math.min

class ScrollNester(detail: Detail, scrollMaterial: ScrollMaterial) {

    private var detailWidth = max(detail._width + detail._margin, detail._height + detail._margin)
    private var detailHeight = min(detail._height + detail._margin, detail._width + detail._margin)
    private var materialWidth = scrollMaterial.width - 20


    fun simpleNest(): Pair<Int, Double> {
        val nestByHeightResult = materialWidth / detailHeight
        val nestByWidthResult = materialWidth / detailWidth
        if (nestByHeightResult > nestByWidthResult) {
            return Pair(nestByHeightResult, ((detailWidth.toDouble() + 50) / 1000))
        } else {
            return Pair(nestByWidthResult, ((detailHeight.toDouble() + 50) / 1000))
        }
    }
}