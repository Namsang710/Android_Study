package com.example.practice_kotlin

fun main(){
    val result = test(1, 3, c = 5)
    println(result)
    test2(id = "윤형님", name = "남윤형", nickname = "윤형")
    println(times(1, 3))
    println(times2(1, 3))

}


// 2. 함수
fun test(a : Int, b : Int = 3, c : Int = 4): Int{
    println(a + b)
    return a + b
}


fun test2(name: String, nickname : String, id: String) = println(name + nickname + id)

fun times(a : Int, b : Int): Int {
    return a * b
}

fun times2(a : Int, b : Int): Int = a * b

