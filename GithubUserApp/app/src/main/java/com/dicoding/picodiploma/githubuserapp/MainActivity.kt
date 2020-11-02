package com.dicoding.picodiploma.githubuserapp

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: GithubUserAdapter

    private lateinit var dataName: Array<String>
    private lateinit var dataUserName: Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataFollowers: IntArray
    private lateinit var dataFollowing: IntArray
    private lateinit var dataRepository: IntArray
    private lateinit var dataPhoto: TypedArray
    private var githubUsers = arrayListOf<GithubUser>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = GithubUserAdapter(this)
        rv_githubuser.adapter = adapter

        prepare()
        addItem()

    }

    private fun prepare() {
        dataPhoto = resources.obtainTypedArray(R.array.avatar)
        dataName = resources.getStringArray(R.array.name)
        dataUserName = resources.getStringArray(R.array.username)
        dataCompany = resources.getStringArray(R.array.company)
        dataLocation = resources.getStringArray(R.array.location)
        dataRepository = resources.getIntArray(R.array.repository)
        dataFollowers = resources.getIntArray(R.array.followers)
        dataFollowing = resources.getIntArray(R.array.following)

    }

    private fun addItem() {
        var data : GithubUser
        for (position in dataName.indices) {
            val githubUser = GithubUser(
                dataPhoto.getResourceId(position, -1),
                dataName[position],
                dataUserName[position],
                dataCompany[position],
                dataLocation[position],
                dataRepository[position],
                dataFollowers[position],
                dataFollowing[position]
            )
            data = githubUser
            githubUsers.add(githubUser)
        }
        adapter.githubUsers = githubUsers
        rv_githubuser.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->

        }
    }


}