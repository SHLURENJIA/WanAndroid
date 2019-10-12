package com.shawn.wanandroid.base

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.os.PersistableBundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import org.greenrobot.eventbus.EventBus

/**
 * 作者：create by @author{ YSH } on 2019/10/10
 * 描述:
 * 修改备注:
 */
abstract class BaseActivity : AppCompatActivity() {

//    protected var mLayoutStateView: MultipleStatusView? = null

    /**
     * 布局id
     */
    @LayoutRes
    protected abstract fun attachLayoutRes(): Int

    /**
     * 初始化View
     */
    protected abstract fun initView()

    /**
     * 初始化Data
     */
    protected abstract fun initData()

    open fun useEventBus(): Boolean = false

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(attachLayoutRes())
        if (useEventBus()) {
            EventBus.getDefault().register(this)
        }
        initView()
        initData()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (useEventBus()) {
            EventBus.getDefault().unregister(this)
        }
    }


}