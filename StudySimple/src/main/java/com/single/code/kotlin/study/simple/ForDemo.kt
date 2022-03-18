package com.single.code.kotlin.study.simple

/**
 * 创建时间：2022/3/18
 * 创建人：singleCode
 * 功能描述：循环和标签
 **/
fun main(){
    //最外层循环自定义加上iii标签
  iii@ for (i in 1..100){
      println("i=$i")
        for (j in 2..200){
            if(j ==5){
                break@iii//通过标签直接返回最外层循环
            }
            println("j=$j")
        }
    }
    val items:List<String> = listOf<String>("test1","test2","test3")
    items.forEach { item-> println(item) }

    for (index in items.indices) {//获取列表下表
        println("下表$index 的值=${items[index]}")
    }
}
class ForTest{
    val str="test"
    fun show(){
        println(this.str)
        println(this@ForTest.str)//类自带标签
    }
}