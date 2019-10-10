package com.shawn.wanandroid.base

/**
 * 作者：create by @author{ YSH } on 2019/10/10
 * 描述:
 * 修改备注:
 */
interface IPresenter<in V : IView> {
    fun attachView(mRootView: V)

    fun detachView()
}