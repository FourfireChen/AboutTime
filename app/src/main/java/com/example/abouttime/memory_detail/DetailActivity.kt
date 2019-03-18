package com.example.abouttime.memory_detail

import android.text.Editable
import android.text.TextWatcher
import android.view.View
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
        detail_remark_edit.addTextChangedListener(object :TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                detail_remark_show.text = detail_remark_edit.text
            }
        })
        detail_title_edit.addTextChangedListener(object :TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                detail_title_show.text = detail_title_edit.text
            }
        })
    }

    private fun toShow() {
        editableOrShowing = false
        detail_toolbar_right.setImageDrawable(getDrawable(R.drawable.ic_edit_white_36dp))
        createMemory()
        detail_remark_editingflag.visibility = View.INVISIBLE
        detail_time_editingflag.visibility = View.INVISIBLE
        detail_title_editingflag.visibility = View.INVISIBLE
        detail_title_edit.visibility = View.INVISIBLE
        detail_title_show.visibility = View.VISIBLE
        detail_remark_edit.visibility = View.INVISIBLE
        detail_remark_show.visibility = View.VISIBLE
    }

    private fun createMemory() {
        memory =
                Memory(detail_title_edit.text.toString(),
                        detail_time.text.toString(),
                        detail_remark_edit.toString())
        viewModel?.createMemory(memory!!)
    }

    private fun toEditable() {
        editableOrShowing = true
        detail_toolbar_right.setImageDrawable(getDrawable(R.drawable.ic_assignment_turned_in_white_36dp))
        detail_remark_editingflag.visibility = View.VISIBLE
        detail_time_editingflag.visibility = View.VISIBLE
        detail_title_editingflag.visibility = View.VISIBLE
        detail_title_edit.visibility = View.VISIBLE
        detail_title_show.visibility = View.INVISIBLE
        detail_remark_edit.visibility = View.VISIBLE
        detail_remark_show.visibility = View.INVISIBLE

    }

    private fun finishEdit() {

    }

    private fun confirm() {

    }

    private fun cancel() {

    }
}