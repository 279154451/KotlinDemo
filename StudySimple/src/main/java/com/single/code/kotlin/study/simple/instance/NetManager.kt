package com.single.code.kotlin.study.simple.instance

/**
 * 创建时间：2022/3/18
 * 创建人：singleCode
 * 功能描述：Kotlin中的单例模式
 **/
class NetManager {
    val name:String = "reada"
    //object 派生类
    object Holder{
        val instance = NetManager()
    }
    //在Kotlin中这个不是内部类，而是嵌套类，所以拿不到外部内的成员变量，如果像让她变成内部类需要如下加上inner
    class InSetClazz{
        fun showName(){
//            println("name=$name")
        }
    }
    inner class InSetClazz2{
        fun showName(){
            println("name=$name")
        }
    }
    //Kotlin中没有static修饰符，所以static变量和函数可以使用派生操作
    companion object{
        var TAG:String = "NetManager"
        fun getInstance():NetManager{
            return Holder.instance;
        }
        var manager:NetManager? = null
        //？表示允许返回null
        fun getManager1():NetManager?{
            if(manager != null){
                manager = NetManager()
            }
            return manager
        }
    }
    fun showName(name:String){
        println("${TAG}:name=$name")
    }
}