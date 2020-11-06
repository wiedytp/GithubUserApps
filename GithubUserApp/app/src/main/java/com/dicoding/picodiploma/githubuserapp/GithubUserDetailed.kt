package com.dicoding.picodiploma.githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.item_githubuser_detailed.*
import kotlinx.android.synthetic.main.item_row_githubuser.*


class GithubUserDetailed : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_githubuser_detailed)

showGithubUserList()

    }

    private fun showGithubUserList() {
        val dataGithubUser = intent.getParcelableExtra("KEY_USER") as GithubUser
        Log.d("GithubUserDetailed", dataGithubUser.repository.toString())
       tv_detail_name.text = dataGithubUser.name
        tv_detail_username.text = dataGithubUser.username
        tv_detail_company.text = dataGithubUser.company
        tv_detail_location.text = dataGithubUser.location
        tv_detail_repository.text = dataGithubUser.repository.toString()
        tv_detail_followers.text = dataGithubUser.followers.toString()
        tv_detail_following.text = dataGithubUser.following.toString()
        img_detail_photo.setImageResource(dataGithubUser.photo)


    }
}