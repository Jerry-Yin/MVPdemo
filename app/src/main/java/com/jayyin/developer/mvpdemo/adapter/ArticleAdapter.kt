package com.jayyin.developer.mvpdemo.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import com.jayyin.developer.mvpdemo.R
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
        var view = LayoutInflater.from(c).inflate(R.layout.item_article, parent, false)
        return ArticleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        var article = dataList[position]
        if (holder != null){
            holder.title.setText(article.titles)
            holder.content.setText("This is the content of this article, that's "+article.content)
        }
    }


    class ArticleViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var title = itemView!!.findViewById<TextView>(R.id.title)
        var content = itemView!!.findViewById<TextView>(R.id.content)

    }
}