package com.example.rahul.listviewkotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.rahul.listviewkotlin.data.HomeFeed
import com.example.rahul.listviewkotlin.R
import com.squareup.picasso.Picasso

/**
 * Created by Rahul on 3/18/18.
 */
class ListViewAdapter(context: Context, val homeFeed: HomeFeed) : BaseAdapter() {

    private val mContext = context
    override fun getView(position: Int, converView: View?, viewGroup: ViewGroup?): View {
       val layoutInflater = LayoutInflater.from(mContext)
        val rowItem=layoutInflater.inflate(R.layout.recyclerview_row_item,viewGroup,false)

        val video= homeFeed.videos.get(position)
        val titleTextView=rowItem.findViewById<TextView>(R.id.title_text_view)
        val thumbnailImageView=rowItem.findViewById<ImageView>(R.id.main_image_view)
        val channleNameTextView=rowItem.findViewById<TextView>(R.id.channel_name_textview)
        val profileImageView=rowItem.findViewById<ImageView>(R.id.profile_image_view)
        titleTextView.text=video.name
        channleNameTextView.text=video.channel.name
        Picasso.get().load(video.imageUrl).into(thumbnailImageView)
        Picasso.get().load(video.channel.profileImageUrl).into(profileImageView)

        return rowItem
    }

    override fun getItem(position: Int): Any {
       return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return homeFeed.videos.count()
    }


}