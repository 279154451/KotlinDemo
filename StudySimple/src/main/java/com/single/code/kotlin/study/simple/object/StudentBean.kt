package com.single.code.kotlin.study.simple.`object`

/**
 * 创建时间：2022/3/18
 * 创建人：singleCode
 * 功能描述：对象支持解构copy功能
 **/
class StudentBean(val name:String ,var age:Int) {

    //函数名必须以component+序号命令
    operator fun component1():String = name
    operator fun component2():Int = age
    operator fun component3():Boolean= false


}

fun main() {
    val stu = StudentBean("xiaoda",12)
    val (n1,n2,n3) = stu;
    println("n1=$n1,n2=$n2,n3=$n3")
}