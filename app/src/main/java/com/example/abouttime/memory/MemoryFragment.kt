package com.example.abouttime.memory

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.abouttime.R
import com.example.abouttime.add.AddActivity
import com.example.abouttime.base.BaseActivity
import com.example.abouttime.base.BaseFragment
import com.example.abouttime.base.BaseViewModel
import com.example.abouttime.bean.Memory
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.add_activity.*
import kotlinx.android.synthetic.main.memory_fra.*

class MemoryFragment : BaseFragment<MemoryViewModel>(R.layout.memory_fra,
        MemoryViewModel::class.java, "拾忆", R.drawable.ic_heart_white_36dp) {

    override fun initData() {

    }

    override fun initView() {
        // 点击跳转
        memory_fab.setOnClickListener { startActivity(AddActivity::class.java as Class<BaseActivity<BaseViewModel>>) }

        barContentTransparent()

        // 生成recyclerview的测试而已
        testList()
    }

    /**
     * 使appbar内的内容在收起来的时候渐变为透明不可见.
     * TODO: 了解一下run关键字怎么用
     */
    private fun barContentTransparent() {
        memory_appbar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            run {
                val height = memory_bar_content.height
                val offsetAbs = Math.abs(verticalOffset).toDouble()
                memory_bar_content.alpha = (1 / height.toFloat()) * (height - offsetAbs).toFloat()
            }

        })
    }

    // 这里就是生成点数据测试一下而已
    private fun testList() {
        var list = mutableListOf<Memory>()
        for (i in 1..8) {
            list.add(Memory(i.toString()))
        }
        val memoryListAdapter = MemoryListAdapter(list)
        memory_list.adapter = memoryListAdapter
        memory_list.layoutManager = LinearLayoutManager(context)
    }

    override fun initContract() {

    }


}
