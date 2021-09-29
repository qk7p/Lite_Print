package com.example.liteprint.util

fun parseInput(input: String): Int {
    return if (input.isNotEmpty() && input.length < 10) {
        input.filter { it.isDigit() }.toInt()
    } else {
        0
    }
}
