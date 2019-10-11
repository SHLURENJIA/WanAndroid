package com.shawn.wanandroid.mvp.model.bean

import com.google.gson.annotations.SerializedName


/**
 * 作者：create by @author{ YSH } on 2019/10/11
 * 描述:
 * 修改备注:
 */
data class HttpResult<T>(
    @SerializedName("data")
    val data: T
) : BaseBean()

/**
 * 首页文章列表
 */
data class ArticleResponseBody(
    @SerializedName("curPage")
    val curPage: Int,
    @SerializedName("datas")
    val datas: MutableList<Article>,
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("over")
    val over: Boolean,
    @SerializedName("pageCount")
    val pageCount: Int,
    @SerializedName("size")
    val size: Int,
    @SerializedName("total")
    val total: Int
)

//文章
data class Article(
    @SerializedName("apkLink")
    val apkLink: String,
    @SerializedName("audit")
    val audit: Int,
    @SerializedName("author")
    val author: String,
    @SerializedName("chapterId")
    val chapterId: Int,
    @SerializedName("chapterName")
    val chapterName: String,
    @SerializedName("collect")
    val collect: Boolean,
    @SerializedName("courseId")
    val courseId: Int,
    @SerializedName("desc")
    val desc: String,
    @SerializedName("envelopePic")
    val envelopePic: String,
    @SerializedName("fresh")
    val fresh: Boolean,
    @SerializedName("id")
    val id: Int,
    @SerializedName("link")
    val link: String,
    @SerializedName("niceDate")
    val niceDate: String,
    @SerializedName("niceShareDate")
    val niceShareDate: String,
    @SerializedName("origin")
    val origin: String,
    @SerializedName("prefix")
    val prefix: String,
    @SerializedName("projectLink")
    val projectLink: String,
    @SerializedName("publishTime")
    val publishTime: Long,
    @SerializedName("selfVisible")
    val selfVisible: Int,
    @SerializedName("shareDate")
    val shareDate: Long,
    @SerializedName("shareUser")
    val shareUser: String,
    @SerializedName("superChapterId")
    val superChapterId: Int,
    @SerializedName("superChapterName")
    val superChapterName: String,
    @SerializedName("tags")
    val tags: List<Tag>,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: Int,
    @SerializedName("userId")
    val userId: Int,
    @SerializedName("visible")
    val visible: Int,
    @SerializedName("zan")
    val zan: Int
)

data class Tag(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)

data class Banner(
    @SerializedName("desc")
    val desc: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("imagePath")
    val imagePath: String,
    @SerializedName("isVisible")
    val isVisible: Int,
    @SerializedName("order")
    val order: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: Int,
    @SerializedName("url")
    val url: String
)

