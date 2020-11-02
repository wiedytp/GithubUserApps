package com.dicoding.picodiploma.githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.item_github_user_detailed.*
import kotlinx.android.synthetic.main.item_row_githubuser.*



class GithubUserDetailed : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_github_user_detailed)


        val dataUser = intent.getParcelableExtra("KEY_USER") as GithubUser

        supportActionBar?.title = dataUser.name
        tv_username.text = dataUser.username
        tv_company.text = dataUser.company
        tv_location.text = dataUser.location
        tv_repository.text = dataUser.repository.toString()
        tv_followers.text = dataUser.followers.toString()
        tv_following.text = dataUser.following.toString()
    }

}