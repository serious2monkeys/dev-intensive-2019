package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeUnit.*

fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

private const val MINUTE_SECONDS = 60L
private const val HOUR_SECONDS = 3600L
private const val DAY_SECONDS = 24 * 60 * 60L

fun Date.add(value: Int, unit: TimeUnit): Date {
    time += when (unit) {
        SECONDS -> value * 1000L
        MINUTES -> (value * MINUTE_SECONDS) * 1000L
        HOURS -> (value * HOUR_SECONDS) * 1000L
        DAYS -> (value * DAY_SECONDS) * 1000L
        else -> throw IllegalArgumentException("Wrong time unit")
    }
    return this
}

fun Date.humanizeDiff(): String {
    var diffSeconds = (Date().time - time) / 1000
    if (diffSeconds == 0L) {
        return "Только что"
    }
    val timeLines = mutableListOf<String>()
    while (diffSeconds != 0L) {
        when {
            diffSeconds > DAY_SECONDS -> run {
                val days = diffSeconds / DAY_SECONDS
                timeLines.add("$days дней")
                diffSeconds -= DAY_SECONDS * days
            }
            diffSeconds > HOUR_SECONDS -> run {
                val hours = diffSeconds / HOUR_SECONDS
                timeLines.add("$hours часов")
                diffSeconds -= HOUR_SECONDS * hours
            }
            diffSeconds > MINUTE_SECONDS -> run {
                val minutes = diffSeconds / MINUTE_SECONDS
                timeLines.add("$minutes минут")
                diffSeconds -= MINUTE_SECONDS * minutes
            }
            else -> run {
                timeLines.add("$diffSeconds секунд")
                diffSeconds = 0
            }
        }
    }
    return timeLines.joinToString(separator = " ") + " назад"
}