package com.example.practice_kotlin


// 9. 타입 체크와 캐스팅
fun main(){
    println(smartcast("안녕"))
    println(smartcast(10))
    println(smartcast(true))
}

fun check(a : Any) : String{
    return when (a) {
        is String -> {
            "문자열"
        }

        is Int -> {
            "숫자"
        }

        else -> {
            "몰라요"
        }
    }
}

fun cast(a : Any){
    val result = (a as? String) ?: "실패"
    println(result)
}

fun smartcast(a: Any) : Int{
    return if(a is String){
        a.length
    } else if(a is Int){
        a.dec()
    } else{
        -1
    }
}
