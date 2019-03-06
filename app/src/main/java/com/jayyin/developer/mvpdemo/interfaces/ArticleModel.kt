package com.jayyin.developer.mvpdemo.interfaces

import com.jayyin.developer.mvpdemo.model.Article

/**
 * @description
 * @author JerryYin
 * @create 2019-02-22 17:37
 **/
interface ArticleModel {

    fun saveArticle(articles: List<Article>)        //保存文章到本地

    fun loadArticleFromCache(listener: onDataListener<List<Article>>)   //加载本地文章

}