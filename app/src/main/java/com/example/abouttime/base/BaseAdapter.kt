package com.example.abouttime.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T>(data: List<T>, @LayoutRes private val layoutId: Int) : RecyclerView.Adapter<BaseViewHolder>() {
    private var data: List<T> = data
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder = BaseViewHolder(LayoutInflater.from(parent.context).inflate(layoutId, parent, false))


    override fun getItemCount(): Int = if (data == null) 0 else data.size
}