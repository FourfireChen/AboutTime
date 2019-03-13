package com.example.abouttime.base

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.abouttime.R

abstract class BaseFragment<T : ViewModel> (@LayoutRes private val layoutId: Int, viewModelClass : Class<T>?): Fragment() {
    constructor(@LayoutRes layoutId: Int) : this(layoutId,null)

    protected var viewModel : T? = null

    init {
        viewModel = viewModelClass?.let { ViewModelProvider.NewInstanceFactory().create(it) }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        initData()

        initView()

        initContract()

        return inflater.inflate(layoutId, container, false)
    }

    abstract fun initData()

    abstract fun initView()

    abstract fun initContract()

    fun startActivity(actvitiy: Class<Activity>, data: Bundle? = null) {
        val intent = Intent(context, actvitiy)
        intent.putExtra(getString(R.string.DATA), data)
        startActivity(intent)
    }
}