package com.example.abouttime.base

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.abouttime.R

abstract class BaseFragment<T : BaseViewModel>(@LayoutRes
                                               val layoutId: Int, viewModelClass: Class<T>? = null,
                                               val title: String? = null,
                                               @DrawableRes val icon: Int = 0) : Fragment() {

    protected var viewModel: T? = null

    init {
        viewModel = viewModelClass?.let { ViewModelProvider.NewInstanceFactory().create(it) }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        initData()

        return inflater.inflate(layoutId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()

        initContract()
    }

    abstract fun initData()

    abstract fun initView()

    abstract fun initContract()

    fun startActivity(actvitiy: Class<BaseActivity<BaseViewModel>>, data: Bundle? = null) {
        val intent = Intent(context, actvitiy)
        intent.putExtra(getString(R.string.data), data)
        startActivity(intent)
    }

}