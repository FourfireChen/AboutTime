package com.example.abouttime.memory


import android.widget.TextView
import com.example.abouttime.R
import com.example.abouttime.base.BaseAdapter
import com.example.abouttime.base.BaseViewHolder
import com.example.abouttime.me.Memory

class MemoryListAdapter(data: List<Memory>?) : BaseAdapter<Memory>(data,
        R.layout.memory_list_item) {
    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.getView<TextView>(R.id.memory_list_item_name).text = data?.get(position)?.name
    }
}