import chapter25._


val m = PrefixMapB[Int]("abc" -> 0, "abd" -> 1, "al" -> 2,
  "all" -> 3, "xy" -> 4)

m.suffixes

m.get("a")
m.get("xy")

m.value

m.withPrefix("a")
m.withPrefix("a").value

m.withPrefix("x")
m.withPrefix("b")

val n = PrefixMapB[Int]("a" -> 0)
n.value
