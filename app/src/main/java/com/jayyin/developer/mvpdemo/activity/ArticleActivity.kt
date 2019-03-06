package com.jayyin.developer.mvpdemo.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar
import com.jayyin.developer.mvpdemo.R
import com.jayyin.developer.mvpdemo.adapter.ArticleAdapter
import com.jayyin.developer.mvpdemo.article.ArticlePresenter
import com.jayyin.developer.mvpdemo.interfaces.ArticleViewInterface
import com.jayyin.developer.mvpdemo.manager.RequestQueueMgr
import com.jayyin.developer.mvpdemo.model.Article
import kotlinx.android.synthetic.main.actvity_article.*
import java.util.*

/**
 * @description
 * @author JerryYin
 * @create 2019-02-22 18:30
 **/
class ArticleActivity : AppCompatActivity(), ArticleViewInterface {

    //    var mRecyclerView: RecyclerView? = null;
//    var mProgressBar: ProgressBar? = null
    var mArticlesList = LinkedList<Article>()
    var mArticleAdapter: ArticleAdapter? = null
    var mPresenter: ArticlePresenter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actvity_article)

        initViews()
        initValues()
        requestData()
    }


    private fun initViews() {
        rcv_article.layoutManager = LinearLayoutManager(this)
        mArticleAdapter = ArticleAdapter(this, mArticlesList)

        rcv_article.setHasFixedSize(true)
        rcv_article.adapter = mArticleAdapter

        //

    }

    private fun initValues() {
        //初始化请求队列
        RequestQueueMgr.init(this)
        //构建presenter中间人； 建立view-model-presenter联系
        mPresenter = ArticlePresenter(this)
    }

    fun requestData() {
        //请求
        mPresenter!!.fetchArticles()
    }

    override fun showArticles(articles: List<Article>) {
        if (mArticlesList.size > 0 && articles.size > 0)
            mArticlesList.clear()
        mArticlesList.addAll(articles)
        mArticleAdapter!!.notifyDataSetChanged()
    }

    override fun showLoading() {
        pgbar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        pgbar.visibility = View.GONE
    }

}