package com.example.abouttime.add

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.abouttime.base.BaseViewModel
import com.example.abouttime.bean.Memory

class AddViewModel : BaseViewModel() {


    fun addMemory(title : String, remark: String, time: String) : LiveData<Memory>{
        return MutableLiveData<Memory>()
    }
}
