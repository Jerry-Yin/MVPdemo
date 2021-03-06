package com.jayyin.developer.mvpdemo.article

import android.util.Log
import com.jayyin.developer.mvpdemo.interfaces.ArticleApi
import com.jayyin.developer.mvpdemo.interfaces.onDataListener
import com.jayyin.developer.mvpdemo.model.Article
import java.util.*
import kotlin.concurrent.thread

/**
 * @description
 *
 *
 * @author JerryYin
 * @create 2019-02-22 18:14
 **/
class ArticleApiImpl : ArticleApi {

    override fun fetchArticles(listener: onDataListener<LinkedList<Article>>) {
        //todo requeset data
        Log.d("ArticleApiImpl", "fetchArticles start...")

        //here's for test data
        Thread(
            Runnable {
                Log.d("ArticleApiImpl", "thread start...")
                Thread.sleep(2000)
                Log.d("ArticleApiImpl", "thread is sleeped for 100ms")
                var list = LinkedList<Article>()

                for (i in 0..10){
                    list.add(i, Article("Title$i", "Image$i", "Content$i"))
                }

                Log.d("ArticleApiImpl", "onComplete()")
                listener.onComplete(list)
            }
        ).start()
    }

    override fun fetchArticleDetails(id: Int) {
        //TODO() //To change body of created functions use File | Settings | File Templates.

    }

}