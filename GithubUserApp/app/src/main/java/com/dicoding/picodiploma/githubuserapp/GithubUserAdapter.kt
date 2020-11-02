package com.dicoding.picodiploma.githubuserapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class GithubUserAdapter internal constructor(private val context: Context) : BaseAdapter() {
    internal var githubUsers = arrayListOf<GithubUser>()

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
        var itemView = view
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_row_githubuser, viewGroup, false)
        }
        val viewHolder = ViewHolder(itemView as View)

        val githubUser = getItem(position) as GithubUser
        viewHolder.bind(githubUser)
        return itemView

    }

    override fun getItem(i: Int): Any = githubUsers[i]

    override fun getItemId(i: Int): Long = i.toLong()

    override fun getCount(): Int = githubUsers.size

    private inner class ViewHolder internal constructor(view: View) {
        private var cvItemRowGithubUser: CardView

        private val imgPhoto : ImageView = view.findViewById(R.id.img_item_photo)
        private val tvName : TextView = view.findViewById(R.id.tv_full_name)
        private val tvLocation : TextView = view.findViewById(R.id.tv_location)
        private val tvCompany : TextView = view.findViewById(R.id.tv_company)

        internal fun bind(githubUser: GithubUser) {
            imgPhoto.setImageResource(githubUser.photo)
            tvName.text = githubUser.name
            tvCompany.text = githubUser.company
            tvLocation.text = githubUser.location

        }
    }
}