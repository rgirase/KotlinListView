package com.example.rahul.listviewkotlin.Data

/**
 * Created by Rahul on 3/19/18.
 */
class HomeFeed (val videos:List<Video>)

class Video(val id:Int, val name: String,val link:String,val imageUrl:String,val numberOfViews:Int,val channle:Channel )

class Channel(val name:String,val profileImageUrl:String,val numberOfSubscribers: Int)
