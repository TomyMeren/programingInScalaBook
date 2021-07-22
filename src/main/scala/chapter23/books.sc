case class Book(title: String, authors: String*)

val books: List[Book] =
  List(
    Book(
      "Structure and Interpretation of Computer Programs",
      "Abelson, Harold", "Sussman, Gerald J."
    ),
    Book(
      "Principles of Compiler Design",
      "Aho, Alfred", "Ullman, Jeffrey"
    ),
    Book(
      "Programming in Modula-2",
      "Wirth, Niklaus"
    ),
    Book(
      "Elements of ML Programming",
      "Ullman, Jeffrey"
    ),
    Book(
      "The Java Language Specification", "Gosling, James",
      "Joy, Bill", "Steele, Guy", "Bracha, Gilad"
    )
  )

for (b <- books;
     a <- b.authors
     if a.startsWith("Gosling")) yield b.title

for (b <- books;
     if b.title.indexOf("Program") >= 0
     ) yield b.title



(for (b1: Book <- books;
      b2: Book <- books
      if b1 != b2;
      au1: String <- b1.authors;
      au2: String <- b2.authors
      if au1 == au2
      ) yield au1).toSet

def repBook(books: List[Book]): List[String] = {
  if (books.isEmpty) List()
  else {
    val autorMirar:Seq[String] = books.head.authors
    val autoresRest:List[String] =  books.tail.flatMap(_.authors)

    autorMirar.filter(au => autoresRest.contains(au)).toList ++ repBook(books.tail)
  }
}

repBook(books)


def removeDupli[A](l:List[A]):List[A] = {
  if(l.isEmpty) List()
  else
    l.head :: removeDupli(l.tail.filter(li => li!=l.head))
}

def removeDupli2[A](l:List[A]):List[A] = {
  if (l.isEmpty) List()
  else
    l.head :: removeDupli(for (li <- l.tail ;
                               if li != l.head) yield li)

}

    removeDupli(List(1,2,3,4,5,1,2,3,1,1))