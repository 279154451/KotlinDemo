package com.single.code.kotlin.study.simple

/**
 * 创建时间：2022/3/18
 * 创建人：singleCode
 * 功能描述：条件语句
 **/
fun main(){
    val num1 = 999
    val num2 = 888
    val max = if(num1>num2) num1 else num2
    println(max)

    //比较判断
    val max2 = if(num1 >num2){
        println("num1 最大")
        num1
    }else{
        println("num2 最大")
        num2
    }
    println(max2)

    //区间内做判断
    val x = 90
    val y = 23
    if(x in 1..50 && y in 1..50){
        println("x,y 符合")
    }else{
        println("x,y 不符合")
    }

    //switch判断
    val num3 = 4;
    when(num3){
        1-> println("等于$num3")
        2-> println("等于$num3")
        3-> println("等于$num3")
        4-> println("等于$num3")
        else-> println("else 等于$num3")
    }
    //switch区间判断
    val num4 = 843
    when(num4){
        in 1..100->{
            println("1..100 $num4")
        }
        else-> println("其他 $num4")
    }
    //switch带返回值
    val  result = when(num4){
        1->{
            println("等于$num4")
            num4
        }
        843->{
            println("等于$num4")
            num4
        }
        else->{
            println("其他值$num4")
            num4
        }
    }
    println("result = $result")
}