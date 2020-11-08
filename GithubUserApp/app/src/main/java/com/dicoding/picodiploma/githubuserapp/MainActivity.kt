package com.dicoding.picodiploma.githubuserapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvUsers: RecyclerView
    private lateinit var listGithubUser: GithubUserAdapter
    private val list = ArrayList<GithubUser>()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvUsers = findViewById(R.id.rvUsers)
        rvUsers.setHasFixedSize(true)

        list.addAll(getListUsers())
        showRecyclerList()
        setListClickAction()
    }

    private fun getListUsers(): ArrayList<GithubUser> {
        val dataName = resources.getStringArray(R.array.name)
        val dataUserName = resources.getStringArray(R.array.username)
        val dataCompany = resources.getStringArray(R.array.company)
        val dataLocation = resources.getStringArray(R.array.location)
        val dataRepository = resources.getIntArray(R.array.repository)
        val dataFollowers = resources.getIntArray(R.array.followers)
        val dataFollowing = resources.getIntArray(R.array.following)
        val dataPhoto = resources.obtainTypedArray(R.array.avatar)

        val listUser = ArrayList<GithubUser>()
        for (position in dataName.indices) {
            val githubUser = GithubUser(
                dataName[position],
                dataUserName[position],
                dataCompany[position],
                dataLocation[position],
                dataRepository[position],
                dataFollowers[position],
                dataFollowing[position],
                dataPhoto.getResourceId(position, -1)
            )
            listUser.add(githubUser)
        }
        return listUser
    }

    private fun showRecyclerList() {
        rvUsers.layoutManager = LinearLayoutManager(this)
listGithubUser = GithubUserAdapter(list)
        rvUsers.adapter = listGithubUser
    }

    private fun setListClickAction() {
        listGithubUser.setOnItemClickCallback(object : GithubUserAdapter.OnItemClickCallback {
            override fun onItemClick(data: GithubUser) {
                val moveIntent = Intent(this@MainActivity, GithubUserDetailed::class.java)
                moveIntent.putExtra("KEY_USER", data)
                startActivity(moveIntent)
            }
        })
    }

}