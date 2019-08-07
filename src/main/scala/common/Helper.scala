package common

object Helper {

  implicit class RicherInt(val v: Int) extends AnyVal {
    def b: String = Integer.toBinaryString(v)
  }
}
