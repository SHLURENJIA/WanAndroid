package com.shawn.wanandroid.ui.activity

import android.os.Build
import android.view.WindowManager
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.shawn.wanandroid.R
import com.shawn.wanandroid.base.BaseActivity
import com.shawn.wanandroid.ui.fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : BaseActivity() {

    private val FRAGMENT_HOME = 0
    private val FRAGMENT_KNOWLEDGE = 1

    private var mIndex = FRAGMENT_HOME

    private var mHomeFragment: HomeFragment? = null

    override fun attachLayoutRes(): Int = R.layout.activity_main

    override fun initView() {
        toolbar.run {
            title = getString(R.string.app_name)
            setSupportActionBar(this)
        }

        bottom_navigation.run {
            setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
            selectedItemId = R.id.action_home
        }

        initDrawLayout()

        nav_view.run {
            setNavigationItemSelectedListener(onDrawerNavigationItemSelectedListener)
        }

        showFragment(mIndex)
    }

    override fun initData() {

    }

    private fun showFragment(index: Int) {
        val translation = supportFragmentManager.beginTransaction()
        hideFragment(translation)
        mIndex = index
        when (index) {
            FRAGMENT_HOME -> {
                toolbar.title = getString(R.string.app_name)
                if (mHomeFragment == null) {
                    mHomeFragment = HomeFragment()
                    translation.add(R.id.container, mHomeFragment!!, "home")
                } else {
                    translation.show(mHomeFragment!!)
                }
            }
            FRAGMENT_KNOWLEDGE -> {

            }

        }
        translation.commit()
    }

    private fun hideFragment(translation: FragmentTransaction) {
        mHomeFragment?.let { translation.hide(it) }
    }

    private fun initDrawLayout() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            var params = window.attributes
            params.flags = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
            drawer_layout.fitsSystemWindows = true
            drawer_layout.clipToPadding = false
        }

        drawer_layout.run {
            var toggle = ActionBarDrawerToggle(
                this@MainActivity,
                this,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
            )
            addDrawerListener(toggle)
            toggle.syncState()
        }
    }

    /**
     * NavigationItemSelect监听
     */
    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            return@OnNavigationItemSelectedListener when (item.itemId) {
                R.id.action_home -> true
                R.id.action_knowledge_system -> true
                else -> false
            }
        }

    /**
     * NavigationView 监听
     */
    private val onDrawerNavigationItemSelectedListener =
        NavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                //do something
            }
            drawer_layout.closeDrawer(GravityCompat.START)
            true
        }

}
