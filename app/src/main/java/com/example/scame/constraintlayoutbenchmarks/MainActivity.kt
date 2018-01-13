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

    private var callbacksCount = 0
    private var durationSumMs: Double = 0.0

    private val frameMetricsAvailableListener = Window.OnFrameMetricsAvailableListener {
        _, frameMetrics, _ ->
        val frameMetricsCopy = FrameMetrics(frameMetrics)
        // Layout measure duration in Nano seconds
        val layoutMeasureDurationNs = frameMetricsCopy.getMetric(FrameMetrics.LAYOUT_MEASURE_DURATION)

        ++callbacksCount
        durationSumMs += layoutMeasureDurationNs / 1_000_000.0
        Log.d(MainActivity::class.java.canonicalName, "layoutMeasureDurationNs: " + layoutMeasureDurationNs)
    }

    private lateinit var feedRv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        feedRv = findViewById(R.id.feed_rv)
        populateAdapter()
    }

    override fun onStart() {
        super.onStart()
        callbacksCount = 0
        durationSumMs = 0.0
        window.addOnFrameMetricsAvailableListener(frameMetricsAvailableListener, frameMetricsHandler)
    }

    override fun onStop() {
        super.onStop()
        window.removeOnFrameMetricsAvailableListener(frameMetricsAvailableListener)
        Log.d(MainActivity::class.java.canonicalName, "callbacksCount: " + callbacksCount)
        Log.d(MainActivity::class.java.canonicalName, "durationSumMs: " + durationSumMs)
        Log.d(MainActivity::class.java.canonicalName, "averageMsg: " + durationSumMs / callbacksCount)
    }

    private fun populateAdapter() {
        val feedList = List(100, { generateFeedModel() })
        feedRv.adapter = FeedAdapter(feedList)
        feedRv.layoutManager = LinearLayoutManager(this)
    }
}
