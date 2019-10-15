package com.shawn.wanandroid.rx

import com.shawn.wanandroid.rx.scheduler.IoMainScheduler

/**
 * 作者：create by @author{ YSH } on 2019/10/14
 * 描述:
 * 修改备注:
 */
object SchedulerUtils {

    fun <T> ioToMain(): IoMainScheduler<T> {
        return IoMainScheduler()
    }

}