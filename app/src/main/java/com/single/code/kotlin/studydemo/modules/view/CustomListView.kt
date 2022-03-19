package com.single.code.kotlin.studydemo.modules.view

import android.content.Context
import android.util.AttributeSet
import android.widget.ListView

/*
 *TODO 如果方法参数中有默认值的，那么 @JvmOverloads 注解可以帮我们生成多个重载方法，
 * 这样方便我们调用，可以省掉一些不关心的参数
 * 但是这个注解也有一些坑：https://blog.csdn.net/wangliblog/article/details/87260335?spm=1001.2101.3001.6661.1&utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7ETopBlog-1.topblog&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7ETopBlog-1.topblog&utm_relevant_index=1
 */
class CustomListView @JvmOverloads
constructor(context: Context, attrs: AttributeSet ? = null, defStyleAttr: Int = 0) :

/*{

    // 传递一个 也能帮你掉i用 三个参数的构造函数
    CustomListView(this)

}*/

ListView(context, attrs, defStyleAttr)
{
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {


        // 测量高度   解决显示不全问题（16 网络复杂的）
        // Java
        // int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);

        // KT
        // shl(bits) – 左移位 (Java’s <<)
        // shr(bits) – 右移位 (Java’s >>)
        val expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE shr(2), MeasureSpec.AT_MOST)

        super.onMeasure(widthMeasureSpec, expandSpec)
    }
}