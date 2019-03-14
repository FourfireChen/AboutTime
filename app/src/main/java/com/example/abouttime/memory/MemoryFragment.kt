package com.example.abouttime.memory

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.abouttime.R
import com.example.abouttime.add.AddActivity
import com.example.abouttime.base.BaseActivity
import com.example.abouttime.base.BaseFragment
import com.example.abouttime.base.BaseViewModel
import com.example.abouttime.bean.Memory
import kotlinx.android.synthetic.main.memory_fra.*

class MemoryFragment : BaseFragment<MemoryViewModel>(R.layout.memory_fra,
        MemoryViewModel::class.java, "拾忆", R.drawable.ic_heart_white_36dp) {

    override fun initData() {

    }

    override fun initView() {
        memory_fab.setOnClickListener { startActivity(AddActivity::class.java as Class<BaseActivity<BaseViewModel>>) }
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
