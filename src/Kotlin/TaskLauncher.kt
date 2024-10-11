package Kotlin

import Kotlin.Tasks.Practice1Task3LMP
import Kotlin.Tasks.TaskSudoku

class TaskLauncher {
    fun start() {
        launchTaskSudoku()
    }

    private fun launchTaskSudoku() {
        val task = TaskSudoku()
        task.prepareTable()
        task.showTable()
    }

    private fun launchTask3Practice1LMP() {
        val task = Practice1Task3LMP()
        task.launchTask()
    }
}