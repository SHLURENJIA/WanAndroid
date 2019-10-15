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

data class HotKey(
    @SerializedName("id") val id: Int,
    @SerializedName("link") val link: String,
    @SerializedName("name") val name: String,
    @SerializedName("order") val order: Int,
    @SerializedName("visible") val visible: Int
)

//常用网站
data class Friend(
    @SerializedName("icon") val icon: String,
    @SerializedName("id") val id: Int,
    @SerializedName("link") val link: String,
    @SerializedName("name") val name: String,
    @SerializedName("order") val order: Int,
    @SerializedName("visible") val visible: Int
)

//知识体系
data class KnowledgeTreeBody(
    @SerializedName("children") val children: MutableList<Knowledge>,
    @SerializedName("courseId") val courseId: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("order") val order: Int,
    @SerializedName("parentChapterId") val parentChapterId: Int,
    @SerializedName("visible") val visible: Int
)

data class Knowledge(
    @SerializedName("children") val children: List<Any>,
    @SerializedName("courseId") val courseId: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("order") val order: Int,
    @SerializedName("parentChapterId") val parentChapterId: Int,
    @SerializedName("visible") val visible: Int
)

// 登录数据
data class LoginData(
    @SerializedName("collectIds") val collectIds: List<Any>,
    @SerializedName("email") val email: String,
    @SerializedName("icon") val icon: String,
    @SerializedName("id") val id: Int,
    @SerializedName("password") val password: String,
    @SerializedName("type") val type: Int,
    @SerializedName("username") val username: String
)

//收藏网站
data class CollectionWebsite(
    @SerializedName("desc") val desc: String,
    @SerializedName("icon") val icon: String,
    @SerializedName("id") val id: Int,
    @SerializedName("link") var link: String,
    @SerializedName("name") var name: String,
    @SerializedName("order") val order: Int,
    @SerializedName("userId") val userId: Int,
    @SerializedName("visible") val visible: Int
)


data class CollectionResponseBody<T>(
    @SerializedName("curPage") val curPage: Int,
    @SerializedName("datas") val datas: List<T>,
    @SerializedName("offset") val offset: Int,
    @SerializedName("over") val over: Boolean,
    @SerializedName("pageCount") val pageCount: Int,
    @SerializedName("size") val size: Int,
    @SerializedName("total") val total: Int
)

data class CollectionArticle(
    @SerializedName("author") val author: String,
    @SerializedName("chapterId") val chapterId: Int,
    @SerializedName("chapterName") val chapterName: String,
    @SerializedName("courseId") val courseId: Int,
    @SerializedName("desc") val desc: String,
    @SerializedName("envelopePic") val envelopePic: String,
    @SerializedName("id") val id: Int,
    @SerializedName("link") val link: String,
    @SerializedName("niceDate") val niceDate: String,
    @SerializedName("origin") val origin: String,
    @SerializedName("originId") val originId: Int,
    @SerializedName("publishTime") val publishTime: Long,
    @SerializedName("title") val title: String,
    @SerializedName("userId") val userId: Int,
    @SerializedName("visible") val visible: Int,
    @SerializedName("zan") val zan: Int
)

// 导航
data class NavigationBean(
    val articles: MutableList<Article>,
    val cid: Int,
    val name: String
)

// 项目
data class ProjectTreeBean(
    @SerializedName("children") val children: List<Any>,
    @SerializedName("courseId") val courseId: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("order") val order: Int,
    @SerializedName("parentChapterId") val parentChapterId: Int,
    @SerializedName("visible") val visible: Int
)

