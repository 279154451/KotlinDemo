package com.single.code.kotlin.studydemo.modules.mvp

/**
 * 创建时间：2022/3/18
 * 创建人：singleCode
 * 功能描述：
 **/
abstract class BasePresenter<V, M> : IBasePresenter where V : IBaseView, M : IBaseModel {
    var view: V? = null;
    var model: M? =null
}