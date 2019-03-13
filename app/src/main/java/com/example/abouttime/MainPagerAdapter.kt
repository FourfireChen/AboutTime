package com.example.abouttime

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.ViewModel
import com.example.abouttime.base.BaseFragment

class MainPagerAdapter(fragmentManager: FragmentManager, private val fragments: List<BaseFragment<out ViewModel>>) : FragmentPagerAdapter(fragmentManager) {
    override fun getCount(): Int = fragments.size

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getPageTitle(position: Int): CharSequence? = fragments[position].getTitle()
}