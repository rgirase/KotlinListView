package com.example.rahul.listviewkotlin.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.rahul.listviewkotlin.R
import com.example.rahul.listviewkotlin.adapter.DetailListViewAdapter
import com.example.rahul.listviewkotlin.data.DetailList
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_detail_view.*
import okhttp3.*
import java.io.IOException

class DetailViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_view)
        detail_list_view.layoutManager = LinearLayoutManager(this)
        fetchJson()
    }


    fun fetchJson() {

        val id= intent.getIntExtra("ID",1)
        val url = "https://api.letsbuildthatapp.com/youtube/course_detail?id="+id
        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call?, e: IOException?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()

                val gson = GsonBuilder().create()

                val detailListData = gson.fromJson(body, Array<DetailList>::class.java)
                runOnUiThread {
                    detail_list_view.adapter = DetailListViewAdapter(detailListData)

                }

            }

        })
    }
}
