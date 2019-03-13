package com.example.abouttime.me

import com.example.abouttime.R
import com.example.abouttime.base.BaseFragment

class MeFragment : BaseFragment<MeViewModel>(R.layout.me_fra,
        MeViewModel::class.java,
        "我的",
        R.drawable.ic_person_white_36dp) {

    override fun initData() {

    }

    override fun initView() {
    }

    override fun initContract() {
    }

}