package com.example.practice_kotlin

fun main(){
    var name : String = "윤형"
    var number : Int = 10

    var nickname: String? = null
    var secondNumber : Int? = null

//    val result = if(nickname == null){
//        "값이 없음"
//    } else{
//        nickname
//    }

    nickname = null
    val size = nickname?.length
    // nickname?: "없음"
    
    println(size)
}