package com.jayyin.developer.mvpdemo.interfaces

import com.jayyin.developer.mvpdemo.model.Article
import java.util.*

/**
 * @description
 * @author JerryYin
 * @create 2019-02-22 18:01
 **/
interface onDataListener<T> {

    fun onComplete(cacheArticles: LinkedList<Article>)

}