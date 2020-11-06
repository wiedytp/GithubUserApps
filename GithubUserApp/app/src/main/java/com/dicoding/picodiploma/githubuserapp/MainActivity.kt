package com.dicoding.picodiploma.githubuserapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_githubuser_detailed.*

class MainActivity : AppCompatActivity() {
    private lateinit var rv_users: RecyclerView
    private lateinit var listGithubUser: GithubUserAdapter
    private val list = ArrayList<GithubUser>()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_users = findViewById(R.id.rv_users)
        rv_users.setHasFixedSize(true)

        list.addAll(getListUsers())
        showRecyclerList()
        setListClickAction()
    }

    fun getListUsers(): ArrayList<GithubUser> {
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
        rv_users.layoutManager = LinearLayoutManager(this)
listGithubUser = GithubUserAdapter(list)
        rv_users.adapter = listGithubUser
    }

    fun setListClickAction() {
        listGithubUser.setOnItemClickCallback(object : GithubUserAdapter.OnItemClickCallback {
            override fun onItemClick(data: GithubUser) {
                val moveIntent = Intent(this@MainActivity, GithubUserDetailed::class.java)
                moveIntent.putExtra("KEY_USER", data)
                startActivity(moveIntent)
            }
        })
    }

}