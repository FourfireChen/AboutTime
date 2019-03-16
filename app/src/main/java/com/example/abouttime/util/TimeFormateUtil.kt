package com.example.abouttime.util

object TimeFormateUtil {
    fun decTimeString(time: String): List<Int> {
        if (time == "") return emptyList()
        val time = time.split("-")
        return listOf(time[0].toInt(), time[1].toInt(), time[2].toInt())
    }


    fun comTimeString(yearMonthDay: List<Int>): String =
            yearMonthDay[0].toString() +
                    "-" +
                    if (yearMonthDay[1] < 10) "0" else "" +
                            yearMonthDay[1].toString() +
                            "-" +
                            if (yearMonthDay[2] < 10) "0" else "" +
                                    yearMonthDay[2].toString()
}