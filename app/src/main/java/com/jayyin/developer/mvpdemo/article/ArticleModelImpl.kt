package com.jayyin.developer.mvpdemo.article

import com.jayyin.developer.mvpdemo.interfaces.onDataListener
import com.jayyin.developer.mvpdemo.model.Article
import com.jayyin.developer.mvpdemo.interfaces.ArticleModel
import java.util.*

/**
 * 模拟 对数据库的存取操作
 * 此处模拟直接存入缓存（内存）
 *
 * @description
 * @author JerryYin
 * @create 2019-02-22 17:59
 **/
class ArticleModelImpl : ArticleModel {

    //模拟本地存储，存储在内存中
    var mCacheArticles = LinkedList<Article>()

    override fun saveArticle(articles: List<Article>) {
        mCacheArticles.addAll(articles)
    }

    override fun loadArticleFromCache(listener: onDataListener<List<Article>>) {
        listener.onComplete(mCacheArticles)
    }
}