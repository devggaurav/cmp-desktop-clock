package com.gc.desktopclock.presentation.calender

import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.LocalDate
import kotlinx.datetime.minus
import kotlinx.datetime.plus


//
// Created by Code For Android on 14/03/25.
// Copyright (c) 2025 CFA. All rights reserved.
//

object Days {

    val daysList = listOf(
        "Sun",
        "Mon",
        "Tue",
        "Wed",
        "Thu",
        "Fri",
        "Sat",

    )





    fun getDaysInMonth(year: Int, month: Int): Int {
        val firstDayOfCurrentMonth = LocalDate(year, month, 1)
        val firstDayOfNextMonth = firstDayOfCurrentMonth.plus(1, DateTimeUnit.MONTH) // Moves to next month

        val lastDayOfThisMonth = firstDayOfNextMonth.minus(1, DateTimeUnit.DAY) // Moves back to last valid day
        return lastDayOfThisMonth.dayOfMonth
    }



    fun getFirstDayOfWeek(year: Int, month: Int): Int {
        val firstDay = LocalDate(year, month, 1)
        return firstDay.dayOfWeek.ordinal+1 // Sunday = 0, Monday = 1, ..., Saturday = 6
    }

}