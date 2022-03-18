package com.single.code.kotlin.study.simple
//TODO 数组
fun main(){

    val numbers:Array<Int> = arrayOf(1,2,3)
    for (number in numbers) {
        println(number)
    }

    //numbers2是大小为20的数组，并设置初始值。初始value=0，然后做运算
    /**
     * 0+200=200
     * 1+200=201
     * 2+200=202
     * .。。。
     * 19+200=219
     */
    val numbers2:Array<Int> = Array(20) { value: Int -> (value + 200) }
    for (number in numbers2) {
        println(number)
    }
}