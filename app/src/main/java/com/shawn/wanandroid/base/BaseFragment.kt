package com.shawn.wanandroid.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.greenrobot.eventbus.EventBus

/**
 * 作者：create by @author{ YSH } on 2019/10/10
 * 描述:
 * 修改备注:
 */
abstract class BaseFragment : Fragment() {

    /**
     * 视图是否加载完毕
     */
    private var isViewPrepare = false

    /**
     * 数据是否已经加载
     */
    private var hasLoadData = false

    /**
     * 加载布局
     */
    @LayoutRes
    abstract fun attachLayoutRes(): Int

    /**
     * 加载视图
     */
    abstract fun initView(view: View)

    /**
     * 初始化Data
     */
    abstract fun initData()

    /**
     * 懒加载
     */
    abstract fun lazyLoad()

    open fun useEventBus(): Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(attachLayoutRes(), null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (useEventBus()) {
            EventBus.getDefault().register(this)
        }
        isViewPrepare = true
        initView(view)
        initData()
        lazyLoadDataIfPrepare()
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            lazyLoad()
            hasLoadData = true
        }
    }


    private fun lazyLoadDataIfPrepare() {
        if (userVisibleHint && isViewPrepare && !hasLoadData) {
            lazyLoad()
            hasLoadData = true
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (useEventBus()) {
            EventBus.getDefault().unregister(this)
        }
    }
}