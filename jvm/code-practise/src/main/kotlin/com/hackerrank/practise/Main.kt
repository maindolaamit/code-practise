package com.hackerrank.practise

import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*

/*
 * Complete the 'timeInWords' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts following parameters:
 *  1. INTEGER h
 *  2. INTEGER m
 */

fun Int.toWords(): String {
    val units = arrayOf(
        "", "one", "two", "three", "four",
        "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve",
        "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
        "eighteen", "nineteen", "twenty"
    )
    return if (this < 20) units[this] else "twenty ${units[this - 20]}"
}

fun Int.toWordsSpecial(): String {
    return if (this == 15) "quarter" else if (this == 30) "half" else this.toWords()
}

fun timeInWords(h: Int, m: Int): String {
    /* Write your code here */
    return when (m) {
        0 -> {
            "${h.toWords()} o' clock"
        }
        in 1..30 -> {
            "${m.toWordsSpecial()} past ${h.toWords()}"
        }
        else -> {
            "${(60 - m).toWordsSpecial()} minutes to ${(h + 1).toWords()}"
        }
    }
}


fun isValidIdentifier(s: String): Boolean {
    if (s.length === 0) return false
    val firstChar: Char = s[0]
    val numberRange = '0'..'9'
    val lowerCaseRange = 'a'..'z'
    val upperCaseRange = 'A'..'Z'
    if (firstChar !== '_' && firstChar !in lowerCaseRange && firstChar !in upperCaseRange) return false
    for (c in s) {
        if (c !== '_' && c !in lowerCaseRange && c !in upperCaseRange && c !in numberRange) return false
    }
    return true
}

fun main(args: Array<String>) {
    println(isValidIdentifier("name"))   // true
    println(isValidIdentifier("_name"))  // true
    println(isValidIdentifier("_12"))    // true
    println(isValidIdentifier(""))       // false
    println(isValidIdentifier("012"))    // false
    println(isValidIdentifier("no$"))    // false
}
