package com.example.scame.constraintlayoutbenchmarks

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.annotation.RequiresApi
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.FrameMetrics
import android.view.Window

class MainActivity : AppCompatActivity() {

    private val frameMetricsHandler = Handler()

    private val frameMetricsAvailableListener = Window.OnFrameMetricsAvailableListener {
        _, frameMetrics, _ ->
        val frameMetricsCopy = FrameMetrics(frameMetrics)
        // Layout measure duration in Nano seconds
        val layoutMeasureDurationNs = frameMetricsCopy.getMetric(FrameMetrics.LAYOUT_MEASURE_DURATION)

        Log.d(MainActivity::class.java.canonicalName, "layoutMeasureDurationNs: " + layoutMeasureDurationNs)
    }

    private lateinit var feedRv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        feedRv = findViewById(R.id.feed_rv)
    }

    override fun onStart() {
        super.onStart()
        window.addOnFrameMetricsAvailableListener(frameMetricsAvailableListener, frameMetricsHandler)
        populateAdapter()
    }

    override fun onStop() {
        super.onStop()
        window.removeOnFrameMetricsAvailableListener(frameMetricsAvailableListener)
    }

    private fun populateAdapter() {
        val feedList = List(1000, { generateFeedModel() })
        feedRv.adapter = FeedAdapter(feedList)
        feedRv.layoutManager = LinearLayoutManager(this)
    }
}
