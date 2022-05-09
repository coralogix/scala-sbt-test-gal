import scala.annotation.tailrec

object BaseConversion {

  /** Given n, computes the number of digits n has in the given base */
  def numDigits(n: Int, base: Int): Int = {
    @tailrec
    def numDigitsLoop(n: Double, base: Int, digitsSoFar: Int): Int = {
      if (n / base >= 1) numDigitsLoop(n / base, base, digitsSoFar + 1)
      else digitsSoFar
    }

    numDigitsLoop(n.toDouble, base, 1)
  }

  def numDigits2(n: Int, base: Int): Int = {
    val guess = (math.log(n) / math.log(base) + 1).toInt
    if (n >= math.pow(base, guess)) {
      guess + 1
    } else guess
  }

  /** Converts given number n into its representation in the given base as a vector */
  def intToVec(n: Int, base: Int): Vector[Int] = {
    val numOfDigits = numDigits(n ,base)

    val (_, qs) = 0.until(numOfDigits).reverse
      .foldLeft((n, Vector.empty[Int])) { case ((m, qsSoFar), index) =>
      val indexOverDigit = math.pow(base, index).toInt
      val quotient = m / indexOverDigit
      val remainder = n % indexOverDigit
      (remainder, qsSoFar.appended(quotient))
    }

    qs
  }

  /** Function which turns a vector n, (where each entry of n is the digit of a number
   n in the given base) into its value as an int */
  def vecToInt(n:Vector[Int], base:Int):Int ={
    val powers=n.indices.reverse
    val entryWPower=n.zip(powers)
      entryWPower.foldLeft(0){case (sumSoFar, (m, basePowerForDigit)) =>
      sumSoFar+(m*math.pow(base, basePowerForDigit).toInt)}

  }
}
