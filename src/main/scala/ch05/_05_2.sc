import common.Helper._

def swap(x: Int, pos1: Int, pos2: Int): Int = {
  val mask1 = 1 << pos1
  val mask2 = 1 << pos2
  val swap = mask1 | mask2

  if ((x & mask1) == (x & mask2)) x
  else x ^ swap
}

73.b

swap(73, 1, 6).b

(1 << 1).b
(1 << 6).b

73 ^ (1 << 1 | 1 << 6)

