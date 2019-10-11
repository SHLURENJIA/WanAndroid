package com.shawn.wanandroid.app

import android.app.Application
import android.content.Context
import kotlin.properties.Delegates

/**
 * 作者：create by @author{ YSH } on 2019/10/11
 * 描述:
 * 修改备注:
 */
class App : Application() {

    companion object {
        private val TAG = "App"

        var context: Context by Delegates.notNull()
            private set

    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext

    }
}