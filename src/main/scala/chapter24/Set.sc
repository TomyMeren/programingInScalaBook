var xs = Set(1, 2, 3, 4, 5, 6)

xs(1)
xs(7)
xs contains 7

Set(3, 4) subsetOf xs
Set(6, 3) subsetOf xs

xs + 7
xs + (8, 9, 7)
xs ++ Set(8, 9, 1)

xs - 1
xs - (4, 3)
xs -- Set(3, 4)
xs.empty

val ys = Set(5, 6, 7, 8, 9)
xs & ys
xs | ys
xs &~ ys

xs += 7
xs

import scala.collection.mutable.Set

val xs = Set(1, 2, 3, 4, 5, 6)
xs += 7
xs
xs += (8, 9)
xs ++= ys
xs add 1
xs add 10

xs
xs - 1
xs -= 2
xs -= (1, 3)
xs --= ys

xs remove 4
val xs = Set(1, 2, 3, 4, 5, 6)
xs retain (_ % 2 == 0)
xs
xs(6) = false
xs
xs.update(6,true)
xs
xs(3) = false
xs
xs.update(3, true)
val ys = xs.clone
xs.clear()
xs
ys