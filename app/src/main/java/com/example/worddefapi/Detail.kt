package com.example.worddefapi

import com.google.gson.annotations.SerializedName

data class Detail(
    @SerializedName("author")
    val author: String,
    @SerializedName("current_vote")
    val currentVote: String,
    @SerializedName("defid")
    val defId: Int,
    @SerializedName("definition")
    val definition: String,
    @SerializedName("example")
    val example: String,
    @SerializedName("permalink")
    val permalink: String,
    @SerializedName("thumbs_down")
    val thumbsDown: Int,
    @SerializedName("thumbs_up")
    val thumbsUp: Int,
    @SerializedName("word")
    val word: String,
    @SerializedName("written_on")
    val writtenOn: String
)

