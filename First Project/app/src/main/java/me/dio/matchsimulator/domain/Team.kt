package me.dio.matchsimulator.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Team (
    @SerializedName("nome")
    val name: String,

    @SerializedName("forca")
    val powerStars: Int,

    @SerializedName("imagem")
    val image: String,

    var score: Int?

    ): Parcelable