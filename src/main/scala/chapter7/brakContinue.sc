val args = List("-a", "-a", "hola", "a", "meh", "hola", "-df.scala", "-a", "f.scala", "t")

def eval(lista: List[String]): Int = {
  if (lista.isEmpty) -1
  else {
    val cab = lista.head
    if (!cab.startsWith("-") && cab.endsWith(".scala")) 0
    else eval(lista.tail) + 1
  }
}

eval(args)

def evalRec(lista: List[String]): Int = {
  def aux(lista: List[String], acc: Int): Int = {
    if (lista.isEmpty) -1
    else {
      val cab = lista.head
      if (!cab.startsWith("-") && cab.endsWith(".scala")) acc
      else aux(lista.tail, acc + 1)
    }
  }

  aux(lista, 0)
}

evalRec(args)

def evalRec2(int: Int): Int = {
  if (int > args.length) -1
  else {
    val cab = args(int)
    if (!cab.startsWith("-") && cab.endsWith(".scala")) int
    else evalRec2(int + 1)
  }
}

evalRec2(0)

@scala.annotation.tailrec
def searchFrom(i: Int): Int = {
  if (i >= args.length) -1
  else if (args(i).startsWith("-")) searchFrom(i + 1)
  else if (args(i).endsWith(".scala")) i
  else {
    searchFrom(i + 1)
  }
}

val i = searchFrom(0)