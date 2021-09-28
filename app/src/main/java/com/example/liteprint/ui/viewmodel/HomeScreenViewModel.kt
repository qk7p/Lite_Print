package com.example.liteprint

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.liteprint.model.FlatMaterial
import com.example.liteprint.model.ScrollMaterial

class HomeScreenViewModel : ViewModel() {

    private var flatMaterialArrayList: ArrayList<FlatMaterial> = arrayListOf(
        FlatMaterial(3050, 2030, 50),
        FlatMaterial(1525, 2030, 50),
        FlatMaterial(1000, 700, 50),
        FlatMaterial(1250, 2050, 50)
    )

    private var scrollMaterialArrayList: ArrayList<ScrollMaterial> = arrayListOf(
        ScrollMaterial(1060),
        ScrollMaterial(1260),
        ScrollMaterial(1370),
        ScrollMaterial(1520),
        ScrollMaterial(1600)
    )

    /* Header viewModels */

    val detailWidth = mutableStateOf("555")
    fun onDetailWidthChanged(newDetailWidth: String) {
        this.detailWidth.value = newDetailWidth
    }

    val detailHeight = mutableStateOf("555")
    fun onDetailHeightChanged(detailHeight: String) {
        this.detailHeight.value = detailHeight
    }

    val detailMargin = mutableStateOf("5")
    fun onDetailMarginChanged(detailMargin: String) {
        this.detailMargin.value = detailMargin
    }

    val materialMargin = mutableStateOf("5")
    fun onMaterialMarginChanged(materialMargin: String) {
        this.materialMargin.value = materialMargin
    }

    /* Body viewModels */


    val isNested = mutableStateOf(false)
    fun onNestedChanged() {
        detailArea.value =
            ((detailHeight.value.toDouble() * detailWidth.value.toDouble()) / 1000000).toString()
        detailPerimeter.value =
            (((detailWidth.value.toDouble() + detailHeight.value.toDouble()) * 2) / 1000).toString()
        isNested.value = true
    }


    val flatMaterialList: MutableState<List<FlatMaterial>> = mutableStateOf(flatMaterialArrayList)

    val scrollMaterialList: MutableState<List<ScrollMaterial>> =
        mutableStateOf(scrollMaterialArrayList)

    val detailArea = mutableStateOf("")

    val detailPerimeter = mutableStateOf("")

}