package com.jayyin.developer.mvpdemo.activity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.jayyin.developer.mvpdemo.R
import com.jayyin.developer.mvpdemo.adapter.ArticleAdapter
import com.jayyin.developer.mvpdemo.presenter.ArticlePresenter
import com.jayyin.developer.mvpdemo.base.BaseActivity
import com.jayyin.developer.mvpdemo.base.BasePresenter
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
class ArticleActivity : BaseActivity<ArticleViewInterface, ArticlePresenter>(), ArticleViewInterface {

    //    var mRecyclerView: RecyclerView? = null;
//    var mProgressBar: ProgressBar? = null
    var mArticlesList = LinkedList<Article>()
    var mArticleAdapter: ArticleAdapter? = null
//    var mPresenter: ArticlePresenter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actvity_article)

        initViews()
        initValues()
        requestData()
    }

    override fun createPresenter(): BasePresenter<ArticleViewInterface>? {
        //构建presenter中间人； 建立view-model-presenter联系
        mPresenter = ArticlePresenter(this)
        return mPresenter
    }

    private fun initViews() {
        rcv_article.layoutManager = LinearLayoutManager(this)
        mArticleAdapter = ArticleAdapter(this, mArticlesList)

        rcv_article.setHasFixedSize(true)
        rcv_article.adapter = mArticleAdapter
    }

    private fun initValues() {
        //初始化请求队列
        RequestQueueMgr.init(this)
    }

    fun requestData() {
        //请求
        (mPresenter!! as ArticlePresenter).fetchArticles()
    }


    override fun showArticles(articles: List<Article>) {
        runOnUiThread {
            if (mArticlesList.size > 0 && articles.size > 0)
                mArticlesList.clear()
            mArticlesList.addAll(articles)
            mArticleAdapter!!.notifyDataSetChanged()
        }
    }

    override fun showLoading() {
        runOnUiThread {
            pgbar.visibility = View.VISIBLE
        }
    }

    override fun hideLoading() {
        runOnUiThread {
            pgbar.visibility = View.GONE
        }
    }

}