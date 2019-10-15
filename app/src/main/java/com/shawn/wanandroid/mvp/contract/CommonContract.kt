package com.shawn.wanandroid.mvp.contract

import com.shawn.wanandroid.base.IPresenter
import com.shawn.wanandroid.base.IView

/**
 * 作者：create by @author{ YSH } on 2019/10/14
 * 描述:
 * 修改备注:
 */
class CommonContract {
    interface View : IView {
        fun showCollectSuccess(success: Boolean)

        fun showCancelCollectSuccess(success: Boolean)
    }

    interface Presenter<in V : View> : IPresenter<V> {
        fun addCollectArticle(id: Int)

        fun cancelCollectArticle(id: Int)
    }
}