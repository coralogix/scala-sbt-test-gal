import org.scalatest.funsuite.AnyFunSuite

class BaseConversionTest extends AnyFunSuite {
  test("BaseConversion on numDigits function") {
    assert(BaseConversion.numDigits(600, 10) === 3)
  }


  test("Base conversion test on numb digits for numbers 1 to 5000" ) {
    val listNumber= 1.to((5000))
    val listNumberTuple=listNumber.map { n =>
      val numDigits = n match {
        case n if n < 10 => 1
        case n if 10 <= n && n < 100 => 2
        case n if 100 <= n && n < 1000 => 3
        case n if 1000 <= n => 4
      }

      (n, 10, numDigits)
    }

    listNumberTuple.foreach { case (x, base, numDigits) =>
      assert(BaseConversion.numDigits2(x, base) === numDigits, x)
    }
  }

  test("Base conversion test on intToVec function"){
    assert(BaseConversion.intToVec(2,2) === "10")
    assert(BaseConversion.intToVec(50,4) === "302")
    assert(BaseConversion.intToVec(500,15) === "235")
  }

  test("Base conversion test on vecToInt function for two examples"){
    assert(BaseConversion.vecToInt(Vector(1,1,0,1),2 ) === 13)
    assert(BaseConversion.vecToInt(Vector(4,4,4,1),5) === 621)
  }

  test("Convert int. to vec. then vec. to int. test") {
    val listOfNum = 1.to(1000)
    listOfNum.foreach { x =>
      val xBase15 = BaseConversion.intToVec(x, 15)
      assert(BaseConversion.vecToInt(xBase15, 15) === x)
    }
  }
}

