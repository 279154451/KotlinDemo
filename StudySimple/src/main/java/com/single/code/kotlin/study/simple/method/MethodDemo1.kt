package com.single.code.kotlin.study.simple.method

/**
 * 创建时间：2022/3/18
 * 创建人：singleCode
 * 功能描述：最简单的高阶函数
 **/
fun main() {
    show(true){
        println("loginSuccess=$it")
        "已经获得结果了=$it"
    }
}
//TODO callBackMethod:(Boolean)->Unit
//callBackMethod方法名
//(Boolean) 方法的（），方法的参数类型是Boolean
//->方法体
//Unit方法的返回值 Unit==void
fun show(isLogin:Boolean,callBackMethod:(Boolean)->String){
    if(isLogin){
        println("登录成功")
       // 调用函数
        var result = callBackMethod.invoke(true)
        println("函数返回=$result")
//        callBackMethod(true)//这样也可以
    }else{
        println("登录失败")
        callBackMethod.invoke(false)
        callBackMethod(false)
    }
}