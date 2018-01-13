package com.example.scame.constraintlayoutbenchmarks

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class FeedAdapter(private val feedList: List<FeedModel>): RecyclerView.Adapter<FeedItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        FeedItemViewHolder(
                LayoutInflater
                        .from(parent.context)
                        .inflate(R.layout.feed_item_constraint, parent, false)
        )


    override fun onBindViewHolder(holder: FeedItemViewHolder, position: Int) = holder.bind(feedList[position])

    override fun getItemCount() = feedList.size
}