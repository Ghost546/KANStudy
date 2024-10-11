package Kotlin.Tasks

class TaskSudoku {
    val table = Array(9) {Array(9) { 0 } }

    fun prepareTable() {

    }



    fun showTable() {
        for (row in table) {
            for (value in row) {
                print("$value ")
            }
            println()
        }
    }
}