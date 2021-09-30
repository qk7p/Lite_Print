package com.example.liteprint

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.liteprint.model.FlatMaterial
import com.example.liteprint.model.ScrollMaterial


class NestingScreenViewModel : ViewModel() {

    var flatMaterialArrayList: ArrayList<FlatMaterial> = arrayListOf()


    var scrollMaterialArrayList: ArrayList<ScrollMaterial> = arrayListOf()


    /* Header viewModels */

    /* Detail Width */

    val detailWidth = mutableStateOf(100)

    fun setDetailWidth(newDetailWidth: String) {
        if (newDetailWidth.isNotEmpty() && newDetailWidth.length < 10) {
            detailWidth.value = newDetailWidth.filter { it.isDigit() }.toInt()
        } else {
            detailWidth.value = 0
        }
    }

    fun getDetailWidthString(): String {
        return detailWidth.value.toString()
    }

    /* Detail Height */

    val detailHeight = mutableStateOf(100)
    fun setDetailHeight(newDetailHeight: String) {
        if (newDetailHeight.isNotEmpty() && newDetailHeight.length < 10) {
            detailHeight.value = newDetailHeight.filter { it.isDigit() }.toInt()
        } else {
            detailHeight.value = 0
        }
    }

    fun getDetailHeightString(): String {
        return detailHeight.value.toString()
    }

    /* Detail Margin */


    val detailMargin = mutableStateOf(5)
    fun setDetailMargin(newDetailMargin: String) {
        if (newDetailMargin.isNotEmpty() && newDetailMargin.length < 10) {
            val filteredInput = newDetailMargin.filter { it.isDigit() }.toInt()
            if (filteredInput < detailWidth.value && filteredInput < detailHeight.value) {
                detailMargin.value = filteredInput
            } else {
                detailMargin.value = 0
            }
        }
    }

    fun getDetailMarginString(): String {
        return detailMargin.value.toString()
    }

    /* Material Width */

    val materialMargin = mutableStateOf(20)
    fun onMaterialMarginChanged(newMaterialMargin: String) {
        if (newMaterialMargin.isNotEmpty() && newMaterialMargin.length < 10) {
            val filteredInput = newMaterialMargin.filter { it.isDigit() }.toInt()
            if (filteredInput < detailWidth.value && filteredInput < detailHeight.value) {
                materialMargin.value = filteredInput
            } else {
                materialMargin.value = 0
            }
        }
    }

    fun getMaterialMarginString(): String {
        return materialMargin.value.toString()
    }

    /* Body viewModels */

/* Nesting viewModels */

    enum class NestingType {
        FlatMaterialNest, ScrollMaterialNest, Nothing
    }

    val nestingState = mutableStateOf(NestingType.Nothing)
    fun setNestingType(type: NestingType) {
        nestingState.value = type
    }

    fun getNestingType(): NestingType {
        return nestingState.value
    }


    val isNested = mutableStateOf(false)
    fun onNestedChanged() {
        if (detailWidth.value > 0 && detailHeight.value > 0) {
            detailArea.value =
                ((detailHeight.value.toDouble() * detailWidth.value.toDouble()) / 1000000).toString()
            detailPerimeter.value =
                (((detailWidth.value.toDouble() + detailHeight.value.toDouble()) * 2) / 1000).toString()
            isNested.value = true
        } else {
            isNested.value = false
        }
    }


    val flatMaterialList: MutableState<List<FlatMaterial>> =
        mutableStateOf(flatMaterialArrayList)

    val scrollMaterialList: MutableState<List<ScrollMaterial>> =
        mutableStateOf(scrollMaterialArrayList)


    /* Bottom viewModels */

    val detailArea = mutableStateOf("")

    val detailPerimeter = mutableStateOf("")

    /* Dialog viewModels */

    val isDialogShow = mutableStateOf(false)
    fun showDialog() {
        isDialogShow.value = true
    }

    fun closeDialog() {
        isDialogShow.value = false
    }

    val newMaterialWidth = mutableStateOf(0)
    fun getNewMaterialWidthString(): String {
        return newMaterialWidth.value.toString()
    }

    fun setNewMaterialWidth(input: String) {
        if (input.isNotEmpty() && input.length < 10) {
            newMaterialWidth.value = input.filter { it.isDigit() }.toInt()
        } else {
            newMaterialWidth.value = 0
        }

    }

    val newMaterialHeight = mutableStateOf(0)
    fun getNewMaterialHeightString(): String {
        return newMaterialHeight.value.toString()
    }

    fun setNewMaterialHeight(input: String) {
        if (input.isNotEmpty() && input.length < 10) {
            newMaterialHeight.value = input.filter { it.isDigit() }.toInt()
        } else {
            newMaterialHeight.value = 0
        }
    }

}


