package com.example.abouttime

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.abouttime.base.BaseFragment
import com.example.abouttime.base.BaseViewModel

class MainPagerAdapter(fragmentManager: FragmentManager,
                       private val fragments: List<BaseFragment<out BaseViewModel>>) :
        FragmentPagerAdapter(fragmentManager) {
    override fun getCount(): Int = fragments.size

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getPageTitle(position: Int): CharSequence? = fragments[position].title


}