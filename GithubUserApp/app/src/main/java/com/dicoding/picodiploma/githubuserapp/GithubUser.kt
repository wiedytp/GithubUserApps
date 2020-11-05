package com.dicoding.picodiploma.githubuserapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GithubUser (
    var name : String,
    var username : String,
    var company : String,
    var location : String,
    var repository : Int,
    var followers : Int,
    var following : Int,
    var photo : Int
): Parcelable