package com.github.bcbsilfd.todo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Task(
    val name: String,
    val startTime: String,
    val endTime: String,
) : Parcelable