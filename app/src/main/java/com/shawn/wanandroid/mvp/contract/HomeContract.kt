package com.shawn.wanandroid.mvp.contract

import com.shawn.wanandroid.mvp.model.bean.ArticleResponseBody
import com.shawn.wanandroid.mvp.model.bean.Banner

/**
 * 作者：create by @author{ YSH } on 2019/10/14
 * 描述:
 * 修改备注:
 */
class HomeContract {

    interface View : CommonContract.View {
        fun scrollToTop()

        fun setBanner(banners: List<Banner>)

        fun setArticles(articles: ArticleResponseBody)
    }

    interface Presenter : CommonContract.Presenter<View> {
        fun reqeustBanner()

        fun requestArticles(num: Int)
    }


}