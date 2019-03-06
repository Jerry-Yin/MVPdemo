package com.jayyin.developer.mvpdemo.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * @description
 * @author JerryYin
 * @create 2019-03-06 17:39
 **/
abstract class BaseActivity<V, T : BasePresenter<V>> : AppCompatActivity() {

    protected var mPresenter: BasePresenter<V>? = null  //持有的presenter对象

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mPresenter = createPresenter()      //创建

        mPresenter!!.attachView(this as V)      //生命周期 信息传递
    }


    //抽象的 创建presenter方法
    @SuppressWarnings("unchecked")
    protected abstract fun createPresenter(): BasePresenter<V>?


    override fun onDestroy() {
        super.onDestroy()
        if (mPresenter != null)
            mPresenter!!.destroy()
    }
}