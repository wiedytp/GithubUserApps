package com.dicoding.picodiploma.githubuser

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GithubUser(
    var photo: Int,
    var name: String,
    var username: String,
    var company: String,
    var location: String,
    var repository: Int,
    var followers: Int,
    var following: Int
) : Parcelable