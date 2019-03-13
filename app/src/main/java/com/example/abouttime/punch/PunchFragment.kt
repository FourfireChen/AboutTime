package com.example.abouttime.punch

import com.example.abouttime.R
import com.example.abouttime.base.BaseFragment

class PunchFragment : BaseFragment<PunchViewModel>(R.layout.punch_fra, PunchViewModel::class.java) {

    override fun initView() {

    }

    override fun initData() {
    }

    override fun initContract() {
    }

    override fun getTitle(): String? = "习惯"

}