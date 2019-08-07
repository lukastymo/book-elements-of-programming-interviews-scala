import scala.collection.mutable

def parity1(xx: Int): Int = {
  var result = 0
  var x = xx
  while (x != 0) {
    result ^= x&1
    x /= 2
  }

  result
}

parity1(1)
parity1(0)
parity1(2)
parity1(3)

val mask = ~0
val lookup = mutable.Map[Int, Int]()

def parity2(x: BigInt): Int = {
  println(x)
  if (BigInt((x&mask).toString) == x) {
    lookup.get(x.toInt) match {
      case None =>
        lookup.put(x.toInt, parity1(x.toInt))
        lookup(x.toInt)
      case Some(value) => value
    }
  } else {
    parity2(x & mask) ^ parity2(x >> 32)
  }
}

parity2(BigInt("1")) // 1
parity2(BigInt("0"))
parity2(BigInt("2"))
parity2(BigInt("3")) // 0

//parity2(BigInt("11", 2))
parity2(BigInt("1111100000111110000011111000001111100000", 2))
parity2(BigInt("1111100000111110000011111000001111000000", 2))

println("Done")

def parity1WithDebug(xx: Int): Int = {
  var result = 0
  var x = xx
  while (x != 0) {
    println("parity1 iter")
    result ^= x&1
    x /= 2
  }

  result
}

parity1WithDebug(Integer.parseInt("10001010", 2))

def parity2WithDebug(xx: Int): Int = {
  var result = 0
  var x = xx
  while (x != 0) {
    println("parity2 iter")
    result ^= 1
    x &= (x - 1)
  }

  result
}

parity2WithDebug(Integer.parseInt("10001010", 2))