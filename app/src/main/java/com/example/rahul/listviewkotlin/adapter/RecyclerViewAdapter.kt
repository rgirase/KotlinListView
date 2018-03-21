package com.example.rahul.listviewkotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.rahul.listviewkotlin.data.HomeFeed
import com.example.rahul.listviewkotlin.R
import com.squareup.picasso.Picasso

/**
 * Created by Rahul on 3/18/18.
 */
class RecyclerViewAdapter(val homeFeed: HomeFeed) : RecyclerView.Adapter<CustomViewHolder>() {
    override fun getItemCount(): Int {
        return homeFeed.videos.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder {

        val layoutInflater = LayoutInflater.from(parent?.context)
        val rowItem = layoutInflater.inflate(R.layout.recyclerview_row_item, parent, false)

        return CustomViewHolder(rowItem)
    }

    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {
        val video = homeFeed.videos.get(position)
        val channle = video.channel

        val thumbnailImageView = holder?.view?.findViewById<ImageView>(R.id.main_image_view)
        val profileImageview = holder?.view?.findViewById<ImageView>(R.id.profile_image_view)

        holder?.view?.findViewById<TextView>(R.id.title_text_view)?.text = video.name
        holder?.view?.findViewById<TextView>(R.id.channel_name_textview)?.text = channle.name
        Picasso.get().load(video.imageUrl).into(thumbnailImageView)
        Picasso.get().load(channle.profileImageUrl).into(profileImageview)
    }
}

class CustomViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

}