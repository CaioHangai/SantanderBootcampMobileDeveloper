import java.util.Scanner

fun main (){

    var valor: Int
    var quociente: Int
    var nota: Int
    var resto: Int

    valor = readLine()!!.toInt()
    println(valor)

    resto = valor

    nota = 100
    quociente = valor / nota
    println("$quociente nota(s) de R$ $nota,00")
    resto = resto % nota

    nota = 50
    quociente = resto / nota
    println("$quociente nota(s) de R$ $nota,00")
    resto = resto % nota

    nota = 20
    quociente = resto / nota
    println("$quociente nota(s) de R$ $nota,00")
    resto = resto % nota

    nota = 10
    quociente = resto / nota
    println("$quociente nota(s) de R$ $nota,00")
    resto = resto % nota

    nota = 5
    quociente = resto / nota
    println("$quociente nota(s) de R$ $nota,00")
    resto = resto % nota

    nota = 2
    quociente = resto / nota
    println("$quociente nota(s) de R$ $nota,00")
    resto = resto % nota

    nota = 1
    quociente = resto / nota
    println("$quociente nota(s) de R$ $nota,00")
   }