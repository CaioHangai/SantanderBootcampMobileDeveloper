import java.util.Scanner

fun main(args: Array<String>) {
    var reader = Scanner(System.`in`)

    var gradesA = reader.nextDouble()
    var gradesB = reader.nextDouble()

    var gradesWeightA = 3.5
    var gradesWeightB = 7.5
    var totalWeight = gradesWeightA + gradesWeightB

    var gradesAverage = (gradesA * gradesWeightA + gradesB * gradesWeightB) / totalWeight

    var AverageFormated = String.format("%.5f", gradesAverage)

    println("MEDIA = $AverageFormated")
}