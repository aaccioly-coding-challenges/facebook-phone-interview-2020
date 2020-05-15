package com.facebook.interview_2020

import scala.math.max

object BinaryStringAdder {

  def add(first: String, second: String): String = {
    val maxLength = max(first.length, second.length)

    val (total, lastCarry) = (padLeft(first, maxLength).view zip padLeft(second, maxLength))
      .map { case (first, second) => (first - '0', second - '0') }
      .foldRight((new StringBuilder, 0)) {
        case ((firstBit, secondBit), (sb, carry)) =>
          val sum = firstBit + secondBit + carry
          (sb.append(sum & 1), sum >>> 1) // same as (sb.append(sum % 2), sum / 2)
      }

    if (lastCarry != 0) lastCarry + total.toString else total.toString()
  }

  private[this] def padLeft(string: String, size: Int, char: Char = '0'): String = {
    char.toString * (size - string.length) + string
  }

}
