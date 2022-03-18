package com.single.code.kotlin.study.simple.`object`

/**
 * 创建时间：2022/3/18
 * 创建人：singleCode
 * 功能描述：
 **/
//Kotlin中的类默认是public final,如果要能够被继承，需要用open打开
open class Person(id: Int) {
    //主构造器
    constructor(id: Int, name: String) : this(id) {//次构造器，需要引用主构造

    }

    constructor(id: Int, set: Boolean) : this(id) {//次构造器,需要引用主构造

    }
    constructor():this(23){

    }
    fun showId(){
//        println("id=$id")
    }
}