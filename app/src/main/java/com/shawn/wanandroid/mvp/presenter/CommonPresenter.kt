package com.shawn.wanandroid.mvp.presenter

import com.shawn.wanandroid.base.BasePresenter
import com.shawn.wanandroid.http.NetManager
import com.shawn.wanandroid.mvp.contract.CommonContract
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * 作者：create by @author{ YSH } on 2019/10/14
 * 描述:
 * 修改备注:
 */
open class CommonPresenter<V : CommonContract.View> : BasePresenter<V>(),
    CommonContract.Presenter<V> {
    override fun addCollectArticle(id: Int) {
        val any = GlobalScope.launch {
            NetManager.service.addCollectArticle(id)
        }
    }

    override fun cancelCollectArticle(id: Int) {

    }

}