package com.example.abouttime.add

import androidx.lifecycle.Observer
import com.example.abouttime.R
import com.example.abouttime.base.BaseActivity
import com.example.abouttime.bean.Memory
import com.google.android.material.snackbar.Snackbar
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import kotlinx.android.synthetic.main.add_activity.*
import java.util.*

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
        add_confirm.setOnClickListener {
            when {
                add_title.text.isEmpty() -> Snackbar.make(add_parent,
                        "请填写标题",
                        Snackbar.LENGTH_SHORT).show()
                add_time.text == "未定义" -> Snackbar.make(add_parent,
                        "请选择时间",
                        Snackbar.LENGTH_SHORT).show()
                else -> {
                    viewModel?.addMemory(add_title.text.toString(),
                            add_remark.text.toString(),
                            add_time.text.toString())
                    finish()
                }
            }
        }
        add_cancel.setOnClickListener {
            finish()
        }
        add_time.setOnClickListener {
            pickDate()
        }
    }

    private fun pickDate() {
        val now = Calendar.getInstance()
        if (add_time.text != "未定义") {
            val time = add_time.text
            now.set(time.split("年")[0].toInt(),
                    time.split("年")[1].split("月")[0].toInt() - 1,
                    time.split("年")[1].split("月")[1].split("日")[0].toInt())
        }

        val dia = DatePickerDialog.newInstance({ _, year, monthOfYear, dayOfMonth ->
            val timeString =
                    year.toString() + "年" + (monthOfYear + 1).toString() + "月" + dayOfMonth.toString() + "日"
            add_time.text = timeString
        }, now)
        dia.show(supportFragmentManager, "DatePickerDialog")
    }

}