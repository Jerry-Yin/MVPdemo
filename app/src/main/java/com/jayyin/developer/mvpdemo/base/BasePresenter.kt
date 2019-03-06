package com.jayyin.developer.mvpdemo.base

import java.lang.ref.Reference
import java.lang.ref.WeakReference

/**
 * @description
 *
 * @param T -- View的抽象接口
 *
 * @author JerryYin
 * @create 2019-03-06 17:27
 **/
abstract class BasePresenter<T> {

    protected var mViewRef: Reference<T>? = null;       //View接口的弱引用

    //建立连接
    fun attachView(view: T) {
        //在view创建的时候建立连接
        if (mViewRef == null)
            mViewRef = WeakReference<T>(view)
    }

    //获取引用的View
    protected fun getViewT(): T? {
        if (mViewRef != null)
            return mViewRef!!.get()
        else
            return null
    }

    //判读是否与view建立了连接
    fun isViewAttached(): Boolean {
        return mViewRef != null && mViewRef!!.get() != null
    }


    //销毁解除连接
    fun destroy() {
        if (mViewRef != null) {
            mViewRef!!.clear()
            mViewRef = null
        }
    }


}