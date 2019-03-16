package com.example.abouttime.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T>(data: List<T>? = null,
                              @LayoutRes
                              private val layoutId: Int,
                              private var listener: OnItemClickListener<T>? = null) : RecyclerView.Adapter<BaseViewHolder>() {


    protected var data: List<T>? = data
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    fun setOnClickListener(listener: OnItemClickListener<T>?) {
        this.listener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder =
            BaseViewHolder(LayoutInflater.from(parent.context).inflate(layoutId, parent, false))

    override fun onBindViewHolder(holder: BaseViewHolder,
                                  position: Int,
                                  payloads: MutableList<Any>) {
        super.onBindViewHolder(holder, position, payloads)

        holder.itemView.setOnClickListener {
            listener?.onItemClick(data?.get(position), position)
        }
    }

    override fun getItemCount(): Int = data?.size ?: 0

    interface OnItemClickListener<T> {
        fun onItemClick(item: T?, poistion: Int)
    }
}