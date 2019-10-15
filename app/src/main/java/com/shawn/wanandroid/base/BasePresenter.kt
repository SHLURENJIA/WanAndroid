package com.shawn.wanandroid.base

import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

/**
 * 作者：create by @author{ YSH } on 2019/10/10
 * 描述:
 * 修改备注:
 */
open class BasePresenter<V : IView> : IPresenter<V> {

    var mRootView: V? = null
        private set

    private var compositeDisposable = CompositeDisposable()

    protected val mPresenterScope: CoroutineScope by lazy {
        CoroutineScope(Dispatchers.Main + Job())
    }

    override fun attachView(mRootView: V) {
        this.mRootView = mRootView
    }

    override fun detachView() {
        this.mRootView = null
        //保证Activity结束时取消正在执行的订阅
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.clear()
        }
    }

    fun checkViewAttached() {
        if (mRootView == null) {
            throw MvpViewNotAttachedException()
        }
    }

    //把subscribe订阅返回的Disposable对象加入管理器，对象销毁的时候情况，就能保证网络请求和声明周期绑定了
    fun addSubscription(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    private class MvpViewNotAttachedException internal constructor() :
        RuntimeException("Please call IPresenter.attachView(IBaseView) before" + " requesting data to the IPresenter")

}