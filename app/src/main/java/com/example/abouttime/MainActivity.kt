package com.example.abouttime

import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import com.example.abouttime.base.BaseActivity
import com.example.abouttime.me.MeFragment
import com.example.abouttime.memory.MemoryFragment
import com.example.abouttime.punch.PunchFragment
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : BaseActivity<MainViewModel>(R.layout.main_activity,
        MainViewModel::class.java) {

    override fun initView() {
        val fragments = listOf(MemoryFragment(), PunchFragment(), MeFragment())
        main_viewpager.adapter = MainPagerAdapter(supportFragmentManager, fragments)
        main_bottom_nav.setupWithViewPager(main_viewpager)
        // 设置每个fragment对应的图标，而title是已经设置好的
        val inflater = LayoutInflater.from(this)
        for (fragment in fragments) {
            val tab = main_bottom_nav.getTabAt(fragments.indexOf(fragment))
            val view = inflater.inflate(R.layout.tab, main_bottom_nav, false)
            tab!!.customView = view
            view.findViewById<TextView>(R.id.tab_text).text = fragment.title
            view.findViewById<ImageView>(R.id.tab_icon).setImageDrawable(getDrawable(fragment.icon))
        }
    }

    override fun initContract() {

    }
}