package com.example.abouttime.base

import android.view.View
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView

class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun <T : View> getView(@IdRes id: Int): T = itemView.findViewById(id)
}