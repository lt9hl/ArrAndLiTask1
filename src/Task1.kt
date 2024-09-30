/*Создать программу, выполняющую следующий функционал:
- запрашивается количество строк и столбцов для двумерного массива
- вводится необходимое количество трехзначных чисел (числа могут повторяться)
- подсчитывается количество различных цифр в полученном массиве
- на консоль выводится двумерный массив из введенных чисел и количество различных цифр используемых в данном массиве
Например, для массива
100   951   101   950
519   999   155   501
510   911   144   554
выведется результат: В массиве использовано 5 различных цифр*/
fun main() {
    println("Введите количество строк и столбцов для двумерного массива через пробел")
    var lenHei = mutableListOf<Int>()
    var arr: Array<Array<Int>>
    try {
        repeat(2) { lenHei.add(readln().toInt()) }
        arr = Array(lenHei[0], { Array(lenHei[1], { 0 }) })
        lenHei.clear()
        for (i in 0..<arr.size)
            for (j in 0..<arr[0].size) {
                var read = readln().toDouble()
                if (read / 100.0 in 1.0..<10.0) {
                    arr[i][j] = read.toInt()
                    while (read > 0) {
                        if (lenHei.count { x -> x == (read % 10).toInt() } == 0)
                            lenHei.add((read % 10).toInt())
                        read /= 10
                    }
                } else return
            }
    } catch (e: Exception) {
        println("Ошибка")
        return
    }
    println("В массиве использовано ${lenHei.size} различных цифр")
    prinArr(arr)
}

fun prinArr(arr: Array<Array<Int>>) {
    for (i in 0..<arr.size) {
        for (j in 0..<arr[0].size) {
            print("${arr[i][j]} \t")
        }
        println()
    }
}

