package com.example.scame.constraintlayoutbenchmarks

import java.security.SecureRandom
import java.util.*

private val AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
private val lenRnd = Random()
private var rnd = SecureRandom()

fun generateFeedModel() = FeedModel(
        randomString(lenRnd.nextInt(100)),
        randomString(lenRnd.nextInt(10)) ,
        randomString(lenRnd.nextInt(300)),
        randomString(lenRnd.nextInt(100)),
        randomString(lenRnd.nextInt(200)),
        randomString(lenRnd.nextInt(50)),
        rnd.nextInt(100),
        rnd.nextInt(1000),
        rnd.nextInt(100)
)

private fun randomString(len: Int): String {
    val sb = StringBuilder(len)
    for (i in 0 until len)
        sb.append(AB[rnd.nextInt(AB.length)])
    return sb.toString()
}