package com.example.rahul.listviewkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.rahul.listviewkotlin.Data.HomeFeed
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_recycler_view.*
import okhttp3.*
import java.io.IOException

class RecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        main_recyclerView.layoutManager = LinearLayoutManager(this)
        fetchJson()
    }


    fun fetchJson() {
        val url = "https://api.letsbuildthatapp.com/youtube/home_feed"
        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()

        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()

                val gson = GsonBuilder().create()

                val homeFeed = gson.fromJson(body, HomeFeed::class.java)
                runOnUiThread {
                    main_recyclerView.adapter = RecyclerViewAdapter(homeFeed)
                }

            }

            override fun onFailure(call: Call?, e: IOException?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })

    }
}
