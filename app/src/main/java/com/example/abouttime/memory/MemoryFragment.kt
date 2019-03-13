package com.example.abouttime.memory

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.abouttime.R
import com.example.abouttime.base.BaseFragment
import com.example.abouttime.me.Memory
import kotlinx.android.synthetic.main.memory_fra.*

class MemoryFragment : BaseFragment<MemoryViewModel>(R.layout.memory_fra,
        MemoryViewModel::class.java, "记忆", R.drawable.ic_heart_white_36dp) {

    override fun initData() {

    }

    override fun initView() {
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
