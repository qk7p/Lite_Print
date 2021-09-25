package com.example.liteprint

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val detailWidth = mutableStateOf("")
    fun onDetailWidthChanged(newDetailWidth: String) {
      this.detailWidth.value = newDetailWidth
    }

    val detailHeight = mutableStateOf("")
    fun onDetailHeightChanged(detailHeight: String) {
        this.detailHeight.value = detailHeight
    }

    val materialHeight = mutableStateOf("")
    fun onMaterialHeightChanged(materialHeight: String) {
        this.materialHeight.value = materialHeight
    }

    val materialWidth = mutableStateOf("")
    fun onMaterialWidthChanged(materialWidth: String) {
        this.materialWidth.value = materialWidth
    }

    val detailMargin = mutableStateOf("")
    fun onDetailMarginChanged(detailMargin: String) {
        this.detailMargin.value = detailMargin
    }

    val materialMargin = mutableStateOf("")
    fun onMaterialMarginChanged(materialMargin: String) {
        this.materialMargin.value = materialMargin
    }


}