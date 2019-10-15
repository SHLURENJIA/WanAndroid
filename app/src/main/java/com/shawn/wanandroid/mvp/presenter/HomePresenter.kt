package com.shawn.wanandroid.mvp.presenter

import com.shawn.wanandroid.mvp.contract.HomeContract
import com.shawn.wanandroid.mvp.model.HomeModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * 作者：create by @author{ YSH } on 2019/10/14
 * 描述:
 * 修改备注:
 */
class HomePresenter : CommonPresenter<HomeContract.View>(), HomeContract.Presenter {

    private val mModel: HomeModel by lazy { HomeModel() }

    override fun reqeustBanner() {
        mPresenterScope.launch(Dispatchers.Main) {
            mRootView?.showLoading()
            val banners = withContext(Dispatchers.IO) {
                mModel.requestBanner()
            }
            mRootView?.apply {
                hideLoading()
                if (banners != null) {
                    setBanner(banners.data)
                }
            }
        }
    }

    override fun requestArticles(num: Int) {
        mPresenterScope.launch {
            mRootView?.showLoading()
            val articles = withContext(Dispatchers.IO) {
                mModel.requestArticles(num)
            }
            mRootView?.apply {
                hideLoading()
                if (articles != null) {
                    setArticles(articles.data)
                }
            }
        }
    }

}