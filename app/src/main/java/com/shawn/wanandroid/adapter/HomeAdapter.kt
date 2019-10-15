package com.shawn.wanandroid.adapter

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.hazz.kotlinmvp.view.recyclerview.ViewHolder
import com.hazz.kotlinmvp.view.recyclerview.adapter.CommonAdapter
import com.shawn.wanandroid.R
import com.shawn.wanandroid.mvp.model.bean.Article
import com.shawn.wanandroid.utils.ImageLoader

/**
 * 作者：create by @author{ YSH } on 2019/10/15
 * 描述:
 * 修改备注:
 */
class HomeAdapter(var context: Context, datas: MutableList<Article>) :
    CommonAdapter<Article>(context, datas, R.layout.item_home_list) {

    override fun bindData(holder: ViewHolder, data: Article, position: Int) {
        data?.let {
            holder.setText(R.id.tv_article_title, it.title)
            holder.setText(R.id.tv_article_author, it.author)
            holder.setText(R.id.tv_article_date, it.niceDate)
            holder.setImageResource(
                R.id.iv_like,
                if (it.collect) R.drawable.ic_like else R.drawable.ic_like_not
            )

            if (it.chapterName.isNotEmpty()) {
                holder.setText(R.id.tv_article_chapterName, it.chapterName)
                holder.getView<TextView>(R.id.tv_article_chapterName).visibility = View.VISIBLE
            } else {
                holder.getView<TextView>(R.id.tv_article_chapterName).visibility = View.INVISIBLE
            }
            if (it.envelopePic.isNotEmpty()) {
                holder.getView<ImageView>(R.id.iv_article_thumbnail)
                    .visibility = View.VISIBLE
                ImageLoader.load(context, it.envelopePic, holder.getView(R.id.iv_article_thumbnail))
            } else {
                holder.getView<ImageView>(R.id.iv_article_thumbnail)
                    .visibility = View.GONE
            }
        }
    }


}