package com.jayyin.developer.mvpdemo.presenter

import com.jayyin.developer.mvpdemo.article.ArticleApiImpl
import com.jayyin.developer.mvpdemo.article.ArticleModelImpl
import com.jayyin.developer.mvpdemo.base.BasePresenter
import com.jayyin.developer.mvpdemo.interfaces.ArticleViewInterface
import com.jayyin.developer.mvpdemo.interfaces.onDataListener
import com.jayyin.developer.mvpdemo.model.Article
import java.util.*

/**
 * @description
 * @author JerryYin
 * @create 2019-02-22 17:35
 **/
class ArticlePresenter(
    //ArticleView接口对象
    private var mArticleView: ArticleViewInterface
) : BasePresenter<ArticleViewInterface>() {

    //文章数据的Model
    var mArticleMode = ArticleModelImpl()
    //从网络获取文章
    var mArticleApi = ArticleApiImpl()

    /**
     * 获取文章的业务
     */
    fun fetchArticles() {
        mArticleView.showLoading()

        mArticleApi.fetchArticles(listener = object : onDataListener<LinkedList<Article>> {

            override fun onComplete(articles: LinkedList<Article>) {
                //数据请求完毕，需要传递给view进行刷新显示
                mArticleView.showArticles(articles)


                mArticleView.hideLoading()

                //存储到本地
                mArticleMode.saveArticle(articles)
            }
        })
    }

    /**
     * 本地加载
     */
    fun loadArticlesFromCache(){
        mArticleMode.loadArticleFromCache(object : onDataListener<List<Article>>{
            override fun onComplete(cacheArticles: LinkedList<Article>) {
                //本地加载数据
                mArticleView.showArticles(cacheArticles)
            }
        })
    }
}