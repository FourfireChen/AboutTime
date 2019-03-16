package com.example.abouttime.memory_detail

import com.example.abouttime.R
import com.example.abouttime.base.BaseActivity
import com.example.abouttime.bean.Memory
import kotlinx.android.synthetic.main.detail_activity.*
import kotlinx.android.synthetic.main.detail_content.*

class DetailActivity : BaseActivity<DetailViewModel>(R.layout.detail_activity,
        DetailViewModel::class.java) {

    private var isCreating = false
    private var memory: Memory? = null
    private var editableOrShowing: Boolean = false

    override fun initData() {
        super.initData()
        // 获取是否是创建时候
        isCreating = intent.getBooleanExtra(getString(R.string.isCreating), false)
        if (!isCreating) {
            // 如果不是创建的时候，则是从list中点进来的时候，是需要获取具体的memory的
            memory = intent.getParcelableExtra(getString(R.string.memory))
        }
    }

    override fun initView() {
        if (isCreating)
            toEditable()
        else
            toShow()
    }

    override fun initContract() {
        detail_toolbar_right.setOnClickListener {
            if (!editableOrShowing)
            // 从展示状态切换到编辑状态
                toEditable()
            else
            // 编辑完成，从编辑状态切换到展示状态
                toShow()
        }
    }

    private fun toShow() {
        editableOrShowing = false
        detail_toolbar_right.setImageDrawable(getDrawable(R.drawable.ic_edit_white_36dp))
        createMemory()
    }

    private fun createMemory() {
        memory =
                Memory(detail_title.text.toString(),
                        detail_time.text.toString(),
                        detail_remark.toString())
        viewModel?.createMemory(memory!!)
    }

    private fun toEditable() {
        editableOrShowing = true
        detail_toolbar_right.setImageDrawable(getDrawable(R.drawable.ic_assignment_turned_in_white_36dp))

    }

    private fun finishEdit() {

    }

    private fun confirm() {

    }

    private fun cancel() {

    }
}