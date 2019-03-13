package com.example.abouttime.base

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.abouttime.R

abstract class BaseActivity<T : ViewModel> (@LayoutRes private val layoutId: Int, private val viewModelClass : Class<T>?) : AppCompatActivity() {
    protected var viewModel : T? = null

    constructor(@LayoutRes layoutId: Int) : this(layoutId,null)

    init {
        viewModel = viewModelClass?.let { ViewModelProvider.NewInstanceFactory().create(it) }
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(layoutId)

        initData()

        initView()

        initContract()
    }

    abstract fun initContract()

    abstract fun initView()

    protected fun initData() {}

    fun startActivity(activity : Class<Activity> , data : Bundle? = null) {
        val intent = Intent(this, activity)
        intent.putExtra(getString(R.string.DATA), data)
        startActivity(intent)
    }
}