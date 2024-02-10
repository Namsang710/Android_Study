package com.example.practice_kotlin

// 클래스
fun main(){

    val user = User("남윤형")
    println(user.age)
    val kid = Kid("아이", 3, "male")

}

open class  User(open val name : String, open var age : Int = 100)


// init 이 부생성자보다 먼저 호출
class Kid(override val name: String, override var age: Int) : User(name, age){
    var gender : String = "female"

    init {
        println("초기화 중 입니다.")
    }
    constructor(name : String, age : Int, gender : String) : this(name, age){
        this.gender = gender
        println("부생성자")
    }
}