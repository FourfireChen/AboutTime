package com.example.abouttime.memory


import android.widget.TextView
import com.example.abouttime.R
import com.example.abouttime.base.BaseAdapter
import com.example.abouttime.base.BaseViewHolder
import com.example.abouttime.bean.Memory
import com.example.abouttime.util.TimeFormateUtil
import java.util.*

class MemoryListAdapter(data: List<Memory>?) : BaseAdapter<Memory>(data,
        R.layout.memory_list_item) {
    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.getView<TextView>(R.id.memory_list_item_name).text = data?.get(position)?.name
        holder.getView<TextView>(R.id.memory_list_item_remark).text = data?.get(position)?.remark
        holder.getView<TextView>(R.id.memory_list_item_time).text = data?.get(position)?.time

        val dayMonthDay = TimeFormateUtil.decTimeString(data?.get(position)?.time!!)
        if (!dayMonthDay.isEmpty()) {
            val dayNow = Calendar.getInstance().time.time
            val start = Calendar.getInstance()
            start.set(dayMonthDay[0], dayMonthDay[1], dayMonthDay[2])
            val dayStart = start.time.time
            val dayDis = (dayNow - dayStart).div(1000 * 3600 * 24)
            holder.getView<TextView>(R.id.memory_list_item_before_or_after)
                    .text = if (dayDis > 0) "前" else "后"
            holder.getView<TextView>(R.id.memory_list_item_days)
                    .text = Math.abs(dayDis).toString()
        }
    }
}