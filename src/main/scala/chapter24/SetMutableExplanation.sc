var xs = Iterable(1,2,3,4,5)

xs = xs + 6
xs += 7
xs

import scala.collection.mutable

val xs = mutable.Iterable(1,2,3,4,5)

//xs = xs + 6 Falla
xs += 6


/////////////////////

val xs = Iterable(1,2,3,4,5)

//Falla xs += 7


var xs = mutable.Iterable(1,2,3,4,5)

xs +=6
xs = xs + 7
xs