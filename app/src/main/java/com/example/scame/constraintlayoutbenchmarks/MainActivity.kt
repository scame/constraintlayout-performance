package com.example.scame.constraintlayoutbenchmarks

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var feedRv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        feedRv = findViewById(R.id.feed_rv)
        populateAdapter()
    }

    private fun populateAdapter() {
        val feedList = List(500, { generateFeedModel() })
        feedRv.adapter = FeedAdapter(feedList)
        feedRv.layoutManager = LinearLayoutManager(this)
    }
}
