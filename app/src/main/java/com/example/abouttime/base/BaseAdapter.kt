package com.example.abouttime.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T>(data: List<T>? = null,
                              @LayoutRes
                              private val layoutId: Int) : RecyclerView.Adapter<BaseViewHolder>() {
    protected var data: List<T>? = data
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder =
            BaseViewHolder(LayoutInflater.from(parent.context).inflate(layoutId, parent, false))


    override fun getItemCount(): Int = data?.size ?: 0
}