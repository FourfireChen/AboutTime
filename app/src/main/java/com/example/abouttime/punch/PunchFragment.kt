package com.example.abouttime.punch

import com.example.abouttime.R
import com.example.abouttime.base.BaseFragment

class PunchFragment : BaseFragment<PunchViewModel>(R.layout.punch_fra,
        PunchViewModel::class.java,
        "打卡",
        R.drawable.ic_punch_white_36dp) {

    override fun initView() {

    }

    override fun initData() {
    }

    override fun initContract() {
    }
}