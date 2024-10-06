package Kotlin.Tasks

import kotlin.math.absoluteValue

fun main() {
    val x = 1
    val y = 0
    println(divide(x,y))
}

fun divide(x: Int, y: Int): Int? {
    if (y==0) {
        return null
    }
    return x/y
}