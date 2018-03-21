package com.example.rahul.listviewkotlin.data

/**
 * Created by Rahul on 3/19/18.
 */
class HomeFeed (val videos:List<Video>)

class Video(val id:Int, val name: String,val link:String,val imageUrl:String,val numberOfViews:Int,val channel:Channel )

class Channel(val name:String,val profileImageUrl:String, val numberOfSubscribers:Int)
