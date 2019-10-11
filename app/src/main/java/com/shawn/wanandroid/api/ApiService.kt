package com.shawn.wanandroid.api

import com.shawn.wanandroid.mvp.model.bean.ArticleResponseBody
import com.shawn.wanandroid.mvp.model.bean.Banner
import com.shawn.wanandroid.mvp.model.bean.HttpResult
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * 作者：create by @author{ YSH } on 2019/10/11
 * 描述:
 * 修改备注:
 */
interface ApiService {

    /**
     * 获取轮播图
     */
    @GET("banner/json")
    fun getBanners(): Observable<HttpResult<List<Banner>>>

    /**
     * 获取文章列表
     */
    @GET("article/list/{pageNum}/json")
    fun getArticles(@Path("pageNum") pageNum: Int): Observable<HttpResult<ArticleResponseBody>>
}