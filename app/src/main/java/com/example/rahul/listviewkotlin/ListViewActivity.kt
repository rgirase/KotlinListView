package com.example.rahul.listviewkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class ListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        val listView = findViewById<ListView>(R.id.main_listView)
        listView.adapter = ListViewAdapter(this)
    }
}
