package com.example.jsonapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jsonapp.data.Post
import com.example.jsonapp.R

class PostAdapter : RecyclerView.Adapter<PostAdapter.MyHolderView>() {

    var dataList: List<Post>? = null

    fun setList(data: List<Post>) {
        this.dataList = data
    }

    class MyHolderView(view: View) : RecyclerView.ViewHolder(view) {
        val titleText: TextView = view.findViewById(R.id.yemekTitle)
        val bodyText: TextView = view.findViewById(R.id.yemekBody)
        fun bindItems(post: Post) {

            titleText.text = post.title
            bodyText.text = post.body
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolderView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        return MyHolderView(view)
    }

    override fun onBindViewHolder(holder: MyHolderView, position: Int) {
        holder.bindItems(dataList!!.get(position))
    }

    override fun getItemCount(): Int {
        if (dataList == null)
            return 0
        else
            return dataList!!.size
    }
}