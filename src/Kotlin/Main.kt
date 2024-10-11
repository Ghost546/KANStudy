package Kotlin

import javax.swing.text.Position

fun main() {
    val taskLauncher = TaskLauncher()
    taskLauncher.start()
}

fun displayUsers() {
    displayUser("Tom", 23, "Manager")
    displayUser("Alice", 21)
    displayUser("Kate")
}

fun displayUser(name: String, age: Int = 18, position: String = "unemployed") {
    println("Name: $name Age = $age Position: $position")
}