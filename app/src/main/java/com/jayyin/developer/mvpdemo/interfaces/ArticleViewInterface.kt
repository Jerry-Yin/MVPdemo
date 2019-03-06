package com.jayyin.developer.mvpdemo.interfaces

import com.jayyin.developer.mvpdemo.model.Article

/**
 * @description
 * 主界面的逻辑接口
 * 用于presenter回调view的操作
 *
 * @author JerryYin
 * @create 2019-02-22 17:36
 **/
interface ArticleViewInterface {

    fun showArticles(articles:List<Article>)

    fun showLoading()

    fun hideLoading()

}