package com.example.scame.constraintlayoutbenchmarks

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

class FeedItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val mainTitle = itemView.findViewById<TextView>(R.id.main_title)
    private val hoursTv = itemView.findViewById<TextView>(R.id.hours_tv)
    private val shortDescription = itemView.findViewById<TextView>(R.id.short_description)
    private val overlayText = itemView.findViewById<TextView>(R.id.overlay_text)
    private val articleStartText = itemView.findViewById<TextView>(R.id.article_start_text)
    private val communityName = itemView.findViewById<TextView>(R.id.community_name)
    private val emotionsNumber = itemView.findViewById<TextView>(R.id.emotions_number)
    private val commentsNumber = itemView.findViewById<TextView>(R.id.comments_number)
    private val sharesNumber = itemView.findViewById<TextView>(R.id.shares_number)

    fun bind(feedModel: FeedModel) {
        mainTitle.text = feedModel.mainTitle
        hoursTv.text = feedModel.hours
        shortDescription.text = feedModel.shortDescription
        overlayText.text = feedModel.overlayText
        articleStartText.text = feedModel.articleStartText
        communityName.text = feedModel.communityName
        emotionsNumber.text = feedModel.emotionsNumber.toString()
        itemView.context.getString(R.string.shares_template, feedModel.commentsNumber.toString())
        commentsNumber.text = itemView.context.getString(R.string.comments_template, feedModel.commentsNumber.toString())
        sharesNumber.text = itemView.context.getString(R.string.shares_template, feedModel.sharesNumber.toString())
    }
}