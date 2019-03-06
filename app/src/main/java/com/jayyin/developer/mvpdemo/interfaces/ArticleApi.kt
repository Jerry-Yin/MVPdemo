package com.jayyin.developer.mvpdemo.interfaces

import com.jayyin.developer.mvpdemo.model.Article

/**
 * @description
 * @author JerryYin
 * @create 2019-02-22 17:38
 **/
interface ArticleApi {

    fun fetchArticles(listener: onDataListener<List<Article>>)     //获取所有文章简介（列表）

    fun fetchArticleDetails(id: Int)    //获取某篇文章明细

}