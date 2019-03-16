package com.example.abouttime.memory

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.abouttime.R
import com.example.abouttime.add.AddActivity
import com.example.abouttime.base.BaseAdapter
import com.example.abouttime.base.BaseFragment
import com.example.abouttime.bean.Memory
import com.example.abouttime.memory_detail.DetailActivity
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.memory_fra.*

class MemoryFragment : BaseFragment<MemoryViewModel>(R.layout.memory_fra,
        MemoryViewModel::class.java, "拾忆", R.drawable.ic_heart_white_36dp) {
    private var adapter: MemoryListAdapter? = null


    override fun initData() {

    }

    override fun initView() {

        barContentTransparent()

        // 生成recyclerview的测试而已
        testList()
    }

    override fun initContract() {
        // 添加按钮点击跳转
        memory_fab.setOnClickListener { startActivity(AddActivity::class.java) }

        adapter?.setOnClickListener(object : BaseAdapter.OnItemClickListener<Memory> {
            override fun onItemClick(item: Memory?, poistion: Int) {
                startActivity(DetailActivity::class.java,
                        Bundle().apply {
                            putParcelable(getString(R.string.memory), item)
                        })
            }
        })
    }

    /**
     * 使appbar内的内容在收起来的时候渐变为透明不可见.
     * TODO: 了解一下run关键字怎么用
     */
    private fun barContentTransparent() {
        memory_appbar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
            run {
                val height = memory_bar_content.height
                val offsetAbs = Math.abs(verticalOffset).toDouble()
                memory_bar_content.alpha = (1 / height.toFloat()) * (height - offsetAbs).toFloat()
            }
        })
    }

    // 这里就是生成点数据测试一下而已
    private fun testList() {
        val list = mutableListOf<Memory>()
        for (i in 1..8) {
            list.add(Memory(i.toString()))
        }
        adapter = MemoryListAdapter(list)
        memory_list.adapter = adapter
        memory_list.layoutManager = LinearLayoutManager(context)
    }
}
