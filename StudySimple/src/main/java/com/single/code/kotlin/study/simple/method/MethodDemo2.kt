package com.single.code.kotlin.study.simple.method

/**
 * 创建时间：2022/3/18
 * 创建人：singleCode
 * 功能描述：高阶函数的定义和实现
 **/
fun main() {
    var method1 :(Int,Int)->Int
//    method1(1,1)//这里不能调用是因为方法还没有实现方法体

    //第一种写法
    // :( 参数类型)
    //={方法具体详情和实现}
    var method2:(Int,Int)->Int={a,b->a+b}//这里定义方法，并实现了方法体
    println("method2=${method2(2,1)}")
    //第二种写法
    var method3 ={a:Int,b:Int->a.toDouble()+b.toDouble()}
    println("method3=${method3(1,2)}")

    var i:Int =0;
    var a = i.also {  4}
    println("a=$a")
    var b = i.let { 4 }
    println("b=$b")
    login("houqing","123213"){result,msg->
        if(result){
            println("msg=$msg")
            1;
        }else{
            println("msg=$msg,登录失败")
            0;
        }

    }
}

/**
 * 高阶函数在业务中的使用
 */
fun login(name:String,password:String,callback:(Boolean,String?)->Int){
    var value:Int;
    if(name!=null && password!=null){
       value = callback.invoke(true,"登录成功")
    }else{
        value = callback.invoke(false,null)
    }
}