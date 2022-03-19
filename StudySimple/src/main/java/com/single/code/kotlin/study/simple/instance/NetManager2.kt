package com.single.code.kotlin.study.simple.instance

/**
 * 创建时间：2022/3/18
 * 创建人：singleCode
 * 功能描述：Kotlin中object会自动生成单例模式
 **/
object NetManager2 {
    val name:String = "reada"

    //在Kotlin中这个不是内部类，而是嵌套类，所以拿不到外部内的成员变量，如果像让她变成内部类需要如下加上inner
    class InSetClazz{
        fun showName(){
//            println("name=$name")
        }
    }
    //Kotlin中没有static修饰符，所以static变量和函数可以使用派生操作
    var TAG:String = "NetManager"
    fun showName(name:String){
        println("${TAG}:name=$name")
    }
}