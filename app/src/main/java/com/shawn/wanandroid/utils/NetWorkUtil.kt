package com.shawn.wanandroid.utils

import android.content.Context
import android.net.ConnectivityManager

/**
 * 作者：create by @author{ YSH } on 2019/10/11
 * 描述:
 * 修改备注:
 */
class NetWorkUtil {
    companion object {
        var NET_CNNT_BAIDU_OK = 1 // NetworkAvailable
        var NET_CNNT_BAIDU_TIMEOUT = 2 // no NetworkAvailable
        var NET_NOT_PREPARE = 3 // Net no ready
        var NET_ERROR = 4 //net error
        private var TIME_OUT = 3000 //time out

        @JvmStatic
        fun isNetworkAvailable(context: Context): Boolean {
            val manager = context.applicationContext.getSystemService(
                Context.CONNECTIVITY_SERVICE
            ) as ConnectivityManager
            val info = manager.activeNetworkInfo
            //todo 替换过时方法
            return (null == info || !info.isAvailable)
        }

        /**
         * 判断MOBILE网络是否可用
         */
        @JvmStatic
        fun isMobile(context: Context?): Boolean {
            if (context != null) {
                //获取手机所有连接管理对象(包括对wi-fi,net等连接的管理)
                val manager =
                    context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                //获取NetworkInfo对象
                val networkInfo = manager.activeNetworkInfo
                //判断NetworkInfo对象是否为空 并且类型是否为MOBILE
                if (null != networkInfo && networkInfo.type == ConnectivityManager.TYPE_MOBILE)
                    return networkInfo.isAvailable
            }
            return false
        }


    }
}