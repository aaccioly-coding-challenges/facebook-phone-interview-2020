package com.facebook.interview_2020

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class BinaryStringAdderTest extends AnyFlatSpec with Matchers {

  "A binary string adder" should "correctly add two binary strings" in {
    BinaryStringAdder.add("1", "0") shouldBe "1"
  }

  it should "add binary strings of different sizes" in {
    BinaryStringAdder.add("11110", "1") shouldBe "11111"
    BinaryStringAdder.add("1", "11110") shouldBe "11111"
  }

  it should "carry the leftmost 1" in {
    BinaryStringAdder.add("11", "1") shouldBe "100"
  }

}
