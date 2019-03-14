package com.example.abouttime.add

import android.util.Log
import android.view.MenuItem
import androidx.lifecycle.Observer
import com.example.abouttime.R
import com.example.abouttime.base.BaseActivity
import com.example.abouttime.bean.Memory
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.add_activity.*

class AddActivity : BaseActivity<AddViewModel>(R.layout.add_activity, AddViewModel::class.java) {

    override fun initView() {
        // 处理了toolbar
        setSupportActionBar(add_toolbar)
    }

    override fun initContract() {
        add_confirm.setOnClickListener {
            viewModel?.addMemory(add_title.text.toString(),
                    add_remark.text.toString(),
                    add_time.text.toString())?.observe(this,
                    Observer<Memory?> { t ->
                        intent.putExtra(getString(R.string.newMemory), t?.let { it })
                        finish()
                    })
        }
        add_cancel.setOnClickListener{
            finish()
        }
    }

}