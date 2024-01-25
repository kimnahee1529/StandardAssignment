package com.nhkim.ui1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class APT(
    val image: Int,
    val monthlyRent: String,
    val roomType: String,
    val description: String
) : Parcelable
