package com.jayyin.developer.mvpdemo.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import com.jayyin.developer.mvpdemo.model.Article
import java.util.*

/**
 * @description
 * @author JerryYin
 * @create 2019-03-06 15:57
 **/
class ArticleAdapter(
    private var c: Context,
    private var dataList: LinkedList<Article>
) :
    RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    class ArticleViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    }
}