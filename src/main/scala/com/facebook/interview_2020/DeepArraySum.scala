package com.facebook.interview_2020

import scala.collection.mutable

object DeepArraySum {

  def sum(array: Array[Any]): BigInt = {
    var processingStack = mutable.Stack[(Array[_], Int, BigInt)]()
    var sum             = BigInt(0)

    processingStack.push((array, 1, 1))

    while (processingStack.nonEmpty) {
      val (arrayToSum, level, formerMultiplier) = processingStack.pop()
      val multiplier                            = formerMultiplier * level // multiplier = level!
      for (elem <- arrayToSum) {
        elem match {
          case i: Int           => sum += (i * multiplier)
          case nested: Array[_] => processingStack.push((nested, level + 1, multiplier))
        }
      }
    }

    sum
  }
}
