package com.shawn.wanandroid.ui.fragment

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.shawn.wanandroid.R
import com.shawn.wanandroid.adapter.HomeAdapter
import com.shawn.wanandroid.base.BaseFragment
import com.shawn.wanandroid.mvp.contract.HomeContract
import com.shawn.wanandroid.mvp.model.bean.Article
import com.shawn.wanandroid.mvp.model.bean.ArticleResponseBody
import com.shawn.wanandroid.mvp.model.bean.Banner
import com.shawn.wanandroid.mvp.presenter.HomePresenter
import kotlinx.android.synthetic.main.fragment_refresh_layout.*
import kotlinx.android.synthetic.main.item_home_banner.view.*

/**
 * 作者：create by @author{ YSH } on 2019/10/12
 * 描述:
 * 修改备注:
 */
class HomeFragment : BaseFragment(), HomeContract.View {


    companion object {
        fun getInstance(): HomeFragment = HomeFragment()
    }

    private val mPresenter: HomePresenter by lazy { HomePresenter() }

    private lateinit var mBanners: ArrayList<Banner>

    private val mArticles = mutableListOf<Article>()

    private val bannerView by lazy {
        layoutInflater.inflate(R.layout.item_home_banner, null)
    }

    private val mHomeAdapter: HomeAdapter by lazy {
        HomeAdapter(context!!, mArticles)
    }

    override fun attachLayoutRes(): Int = R.layout.fragment_refresh_layout

    override fun initView(view: View) {
        mPresenter.attachView(this)

        swipeRefreshLayout.run {
            isRefreshing = true
            setOnRefreshListener(onRefreshListener)
        }
    }

    override fun initData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun lazyLoad() {
        mPresenter.reqeustBanner()
        mPresenter.requestArticles(0)
    }

    override fun scrollToTop() {
        recyclerView.run {
            if ((layoutManager as LinearLayoutManager).findFirstVisibleItemPosition() > 20) {
                scrollToPosition(0)
            } else {
                smoothScrollToPosition(0)
            }
        }
    }

    override fun setBanner(banners: List<Banner>) {
        mBanners = banners as ArrayList<Banner>
        val bannerFeedList = ArrayList<String>()
        val bannerTitleList = ArrayList<String>()
        mBanners.forEach {
            bannerFeedList.add(it.imagePath)
            bannerTitleList.add(it.title)
        }
        bannerView.banner.run {
            setAutoPlayAble(bannerFeedList.size > 1)
            setData(bannerFeedList, bannerTitleList)
//            setAdapter(bannerAdapter)
        }
    }

    override fun setArticles(articles: ArticleResponseBody) {
        articles.datas?.let {
            mArticles.clear()
            mArticles.addAll(it)
            mHomeAdapter.notifyDataSetChanged()
        }
    }

    override fun showCollectSuccess(success: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showCancelCollectSuccess(success: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private val onRefreshListener = SwipeRefreshLayout.OnRefreshListener {
        mPresenter.reqeustBanner()
        mPresenter.requestArticles(0)
    }

}