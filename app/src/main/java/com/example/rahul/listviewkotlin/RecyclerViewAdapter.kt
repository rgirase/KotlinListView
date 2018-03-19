package com.example.rahul.listviewkotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by Rahul on 3/18/18.
 */
class RecyclerViewAdapter: RecyclerView.Adapter<CustomViewHolder>() {

    private  val names= arrayListOf<String>("Android","Kotlin","Java","XML","Git")
    override fun getItemCount(): Int {
        return names.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder {

        val layoutInflater = LayoutInflater.from(parent?.context)
        val rowItem=layoutInflater.inflate(R.layout.row_item,parent,false)

        return CustomViewHolder(rowItem)
    }

    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {
    }
}

class CustomViewHolder(v:View): RecyclerView.ViewHolder(v) {

}