
val fruita = "apples" :: ("oranges" :: ("pinapple" :: chapter22.Nil))

val fruita2 = "apples" :: "oranges" :: "pinapple" :: chapter22.Nil


val listaDesordenada = List(3, 4, 5, 2, 4, 7, 9)
val listaOrdenada = List(2, 4)

def insert(x: Int, xs: List[Int]): List[Int] = {
  if (xs.isEmpty || x <= xs.head) x :: xs
  else xs.head :: insert(x, xs.tail)
}

def ordenadar(l: List[Int]): List[Int] = {
  if (l.isEmpty) chapter22.Nil
  else insert(l.head, ordenadar(l.tail))
}

insert(7, insert(1, insert(3, listaOrdenada)))

ordenadar(listaDesordenada)

val List(a, b, c) = fruita

val a :: b :: resto = fruita

def insert2(x: Int, xs: List[Int]): List[Int] = xs match {
  case chapter22.Nil => x :: xs
  case y :: ys => {
    if (x <= y) x :: xs
    else y :: insert2(x, ys)
  }
}

def ordenadar2(l: List[Int]): List[Int] = l match {
  case chapter22.Nil => chapter22.Nil
  case x :: xs => insert2(x, ordenadar2(xs))
}

ordenadar2(listaDesordenada)