package com.dicoding.picodiploma.githubuserapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_githubuser_detailed.view.*
import kotlinx.android.synthetic.main.item_row_githubuser.view.*

class GithubUserAdapter (private val listUser : ArrayList<GithubUser>) :
    RecyclerView.Adapter<GithubUserAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(
        viewGroup : ViewGroup,
        i: Int
    ): ListViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_githubuser, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listUser.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
       holder.bind(listUser[position])
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClick(listUser[holder.adapterPosition])
        }
    }

    class ListViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data : GithubUser) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(data.photo)
                    .apply(RequestOptions().override(55, 55))
                    .into(img_item_photo)
                tv_item_name.text = data.name
                tv_item_company.text = data.company
                tv_item_location.text = data.location
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClick(data: GithubUser)
    }
}

