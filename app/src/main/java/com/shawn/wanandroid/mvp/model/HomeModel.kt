package com.shawn.wanandroid.mvp.model

import com.shawn.wanandroid.http.NetManager
import com.shawn.wanandroid.mvp.model.bean.ArticleResponseBody
import com.shawn.wanandroid.mvp.model.bean.Banner
import com.shawn.wanandroid.mvp.model.bean.HttpResult

/**
 * 作者：create by @author{ YSH } on 2019/10/14
 * 描述:
 * 修改备注:
 */
class HomeModel : CommonModel() {
    fun requestBanner(): HttpResult<List<Banner>>? {
        return NetManager.service.getBanners().execute().body()
    }

    suspend fun requestArticles(num: Int): HttpResult<ArticleResponseBody>? {
        return NetManager.service.getArticles(num).execute().body()
    }
}