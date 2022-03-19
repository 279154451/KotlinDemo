package com.single.code.kotlin.study.simple.method

/**
 * 创建时间：2022/3/19
 * 创建人：singleCode
 * 功能描述：高阶函数：自定义扩展函数
 **/
var name:String="test"
fun main() {
    method1().myRun {
    }
    method1().myRun2 { it
        println("method1 myRun2 return=$it")
    }
   var result= name.myRun {
        println("name myRun $this")
        true
    }
    println("name.myRun return= $result")
    name.myRun2 {
        println("name myRun2 block param=$it")
    }

    myWith(name){
        println("myWith block run ")
    }
    name.myWith1(name){
        println("name.myWith1 block run")
    }
   var value= name.myLet {
        println("myLet block run $it")
    }

    var  r = name.myLet1 {
        println("myLet1 block run $it")
    }

}
fun method1(){
    println("方法执行中")
}
//TODO T.myRun：T表示所有类型（包括函数类型），给所有类型定义一个扩展函数
//TODO block:T.()->R
//block 高阶函数名
//T.() 意思是给T来一个匿名函数
//->R 高阶函数执行后返回R
fun <T,R> T.myRun(block:T.()->R):R{
    return block()//调用匿名函数
}
//和上面的函数等价
//fun <T,R> T.myRun(block:()->R):R{
//    return block()//调用匿名函数
//}
fun <T,R> T.myRun2(block:T.(Boolean)->R):R{
    return block(true)//调用匿名函数
}
//只针对当前类扩展函数
fun <T,R> myWith(input:T,block:T.()->R):R{
    return input.block()
}
//针对任何对象的扩展函数
fun <T,R> T.myWith1(input:T,block:T.()->R):R{
    return input.block()
}
//返回高阶函数结果，形成闭包
fun<T,R>T.myLet(block:T.(T)->R):R{
    //T == this
    //block(this) == this
    return block(this)
}
//返回T本身
fun<T,R>T.myLet1(block:T.(T)->R):T{
    //T == this
    //block(this) == this
    block(this)
    return this;
}
