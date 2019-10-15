package com.shawn.wanandroid.widget.behavior

import android.animation.ObjectAnimator
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat

/**
 * 作者：create by @author{ YSH } on 2019/10/12
 * 描述:
 * 修改备注:
 */
class BottomNavigationBehavior : CoordinatorLayout.Behavior<View>() {

    private var outAnimator: ObjectAnimator? = null
    private var inAnimator: ObjectAnimator? = null

    /**
     * 垂直滑动
     */
    override fun onStartNestedScroll(
        coordinatorLayout: CoordinatorLayout, child: View, directTargetChild: View,
        target: View, axes: Int, type: Int
    ): Boolean {
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL
    }

    override fun onNestedPreScroll(
        coordinatorLayout: CoordinatorLayout,
        child: View,
        target: View,
        dx: Int,
        dy: Int,
        consumed: IntArray,
        type: Int
    ) {
        if (dy > 0) {// 上滑隐藏
            if (outAnimator == null) {

                outAnimator =
                    ObjectAnimator.ofFloat(child, "translationY", 0f, child.height.toFloat())
                outAnimator?.duration = 200
            }
            outAnimator?.let {
                if (!it.isRunning && child.translationY <= 0) {
                    it.start()
                }
            }
        } else if (dy < 0) {// 下滑显示
            if (inAnimator == null) {
                inAnimator =
                    ObjectAnimator.ofFloat(child, "translationY", child.height.toFloat(), 0f)
                inAnimator?.duration = 200
            }
            inAnimator?.let {
                if (!it.isRunning && child.translationY >= child.height) {
                    it.start()
                }
            }
        }
    }


}