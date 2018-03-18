package com.example.rahul.listviewkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

/**
 * Created by Rahul on 3/18/18.
 */
class ListViewAdapter(context: Context) : BaseAdapter() {

    private val mContext = context
    private  val names= arrayListOf<String>("Android","Kotlin","Java","XML","Git")
    override fun getView(position: Int, converView: View?, viewGroup: ViewGroup?): View {
       val layoutInflater = LayoutInflater.from(mContext)
        val rowItem=layoutInflater.inflate(R.layout.row_item,viewGroup,false)

        val nameTextView=rowItem.findViewById<TextView>(R.id.nameView)
        nameTextView.text=names.get(position)

        val rowCountTextView=rowItem.findViewById<TextView>(R.id.subView)
        rowCountTextView.text="Number of Rows: $position"

        return rowItem
    }

    override fun getItem(p0: Int): Any {
       return "TEST"
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return names.size
    }


}