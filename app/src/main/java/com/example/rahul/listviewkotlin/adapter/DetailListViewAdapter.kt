package com.example.rahul.listviewkotlin.adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.rahul.listviewkotlin.R
import com.example.rahul.listviewkotlin.activities.DetailViewActivity
import com.example.rahul.listviewkotlin.activities.WebviewActivity
import com.example.rahul.listviewkotlin.data.DetailList
import com.example.rahul.listviewkotlin.data.Video
import com.squareup.picasso.Picasso

/**
 * Created by Rahul on 3/20/18.
 */
class DetailListViewAdapter(val detailList: Array<DetailList>) : RecyclerView.Adapter<DetailListViewHolder>() {
    override fun onBindViewHolder(holder: DetailListViewHolder?, position: Int) {
        val thumbnailImageView = holder?.view?.findViewById<ImageView>(R.id.list_imageView)
        val listNameTextView = holder?.view?.findViewById<TextView>(R.id.nameView)
        val durationTextView = holder?.view?.findViewById<TextView>(R.id.durationTextView)

        listNameTextView?.text = detailList.get(position).name
        durationTextView?.text = detailList.get(position).duration
        Picasso.get().load(detailList.get(position).imageUrl).into(thumbnailImageView)

        holder?.detailList = detailList.get(position)
    }

    override fun getItemCount(): Int {
        return detailList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): DetailListViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val rowItem = layoutInflater.inflate(R.layout.detail_row_item, parent, false)

        return DetailListViewHolder(rowItem)
    }

}

class DetailListViewHolder(val view: View, var detailList: DetailList? = null) : RecyclerView.ViewHolder(view) {

    init {
        view.setOnClickListener {
            val intent = Intent(view.context, WebviewActivity::class.java)
            intent.putExtra("Link", detailList?.link)
            view.context.startActivity(intent)
        }
    }
}