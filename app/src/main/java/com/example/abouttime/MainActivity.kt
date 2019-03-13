package com.example.abouttime

import com.example.abouttime.base.BaseActivity
import com.example.abouttime.me.MeFragment
import com.example.abouttime.memory.MemoryFragment
import com.example.abouttime.punch.PunchFragment
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : BaseActivity<MainViewModel>(R.layout.main_activity, MainViewModel::class.java) {

    override fun initView() {
        val fragments = listOf(MemoryFragment(), PunchFragment(), MeFragment())
        main_viewpager.adapter = MainPagerAdapter(supportFragmentManager, fragments)
        main_bottom_nav.setupWithViewPager(main_viewpager)

    }

    override fun initContract() {

    }
}