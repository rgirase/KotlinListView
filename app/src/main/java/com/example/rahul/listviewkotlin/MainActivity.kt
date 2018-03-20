package com.example.rahul.listviewkotlin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Button
import com.example.rahul.listviewkotlin.Data.HomeFeed
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_list_view.*
import kotlinx.android.synthetic.main.activity_recycler_view.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setOnClickListener()
    }


    fun setOnClickListener(){
        val showListView= findViewById<Button>(R.id.showListView)
        showListView.setOnClickListener{
            val intent= Intent(this,ListViewActivity::class.java)
            startActivity(intent)
        }

        val showRecyclerView=findViewById<Button>(R.id.showRecyclerView)
        showRecyclerView.setOnClickListener {
            val intent=Intent(this,RecyclerViewActivity::class.java)
            startActivity(intent)
        }
    }


}
