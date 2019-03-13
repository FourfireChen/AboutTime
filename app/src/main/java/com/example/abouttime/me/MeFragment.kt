package com.example.abouttime.me

import com.example.abouttime.R
import com.example.abouttime.base.BaseFragment

class MeFragment : BaseFragment<MeViewModel>(R.layout.me_fra, MeViewModel::class.java) {
    override fun initData() {

    }

    override fun initView() {
    }

    override fun initContract() {
    }

    override fun getTitle(): String? = "我的"
}