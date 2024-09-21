package Kotlin


import java.util.Scanner

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    val scanner = Scanner(System.`in`)
    var resultGrant: Double
    var baseGrant = 1000.0
    var marker = false

    print("Средний бал: ")
    val averageGrade = scanner.nextDouble()
    println()

    if (averageGrade>=5.0) {
        print("Учавстует ли студент в общественной жизни(true/false): ")
        marker = scanner.nextBoolean()
        println()
    }

    if(averageGrade>=8.0 && marker == false) {
        resultGrant = baseGrant*1.25
        showResultGrant(resultGrant)
    } else {
        if (averageGrade>=8.0 && marker == true) {
            resultGrant = baseGrant*1.40
            showResultGrant(resultGrant)
        } else {
            if (averageGrade>=5.0 && marker == true) {
                resultGrant = baseGrant*1.15
                showResultGrant(resultGrant)
            } else {
                if (averageGrade >= 5.0 && marker == false) {
                    showResultGrant(baseGrant)
                } else {
                    println("Студент не получит стипендию")
                }
            }
        }
    }



}

fun showResultGrant(resultGrant: Double) {
    println("Студент получит: $resultGrant")
}