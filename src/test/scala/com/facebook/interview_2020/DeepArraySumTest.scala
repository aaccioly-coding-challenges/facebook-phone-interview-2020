package com.facebook.interview_2020

import com.facebook.interview_2020.DeepArraySum.sum
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class DeepArraySumTest extends AnyFlatSpec with Matchers {

  "Deep array sum" should "sum the elements of an array multiplied by their depth" in {
    val array = Array(2, 3, Array(9, Array(1, 2)), 4)
    sum(array) shouldBe 45
  }
  it should "return 0 for empty arrays" in {
    sum(Array()) shouldBe 0
  }

  it should "return 0 for a multilevel empty array" in {
    sum(Array(Array(Array()))) shouldBe 0
  }

  it should "not overflow for large arrays" in {
    // array nested 10000 levels. Sum should be 10000!
    val array: Array[Any] = (1 until 10000).foldLeft(Array(1): Array[Any]) { (array, _) => Array(array) }
    val result            = sum(array).toString()

    // https://coolconversion.com/math/factorial/What-is-the-factorial-of_10000_%3F
    result should startWith("2846259680917054518906")
    result should endWith("0" * 2499)
    result should have size 35660
  }
}
