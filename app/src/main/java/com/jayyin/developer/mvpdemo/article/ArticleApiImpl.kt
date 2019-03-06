package com.jayyin.developer.mvpdemo.article

import com.jayyin.developer.mvpdemo.interfaces.ArticleApi
import com.jayyin.developer.mvpdemo.interfaces.onDataListener
import com.jayyin.developer.mvpdemo.model.Article

/**
 * @description
 *
 *
 * @author JerryYin
 * @create 2019-02-22 18:14
 **/
class ArticleApiImpl : ArticleApi {

    override fun fetchArticles(listener: onDataListener<List<Article>>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun fetchArticleDetails(id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}