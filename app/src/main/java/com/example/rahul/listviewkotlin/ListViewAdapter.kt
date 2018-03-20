package com.example.rahul.listviewkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.rahul.listviewkotlin.Data.HomeFeed
import com.squareup.picasso.Picasso

/**
 * Created by Rahul on 3/18/18.
 */
class ListViewAdapter(context: Context, val homeFeed: HomeFeed) : BaseAdapter() {

    private val mContext = context
    private  val names= arrayListOf<String>("Android","Kotlin","Java","XML","Git")
    override fun getView(position: Int, converView: View?, viewGroup: ViewGroup?): View {
       val layoutInflater = LayoutInflater.from(mContext)
        val rowItem=layoutInflater.inflate(R.layout.recyclerview_row_item,viewGroup,false)

        val video= homeFeed.videos.get(position)
        val titleTextView=rowItem.findViewById<TextView>(R.id.title_text_view)
        titleTextView.text=video.name
        val thumbnailImageView=rowItem.findViewById<ImageView>(R.id.main_image_view)
        Picasso.get().load(video.imageUrl).into(thumbnailImageView)

        return rowItem
    }

    override fun getItem(p0: Int): Any {
       return p0
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return homeFeed.videos.count()
    }


}