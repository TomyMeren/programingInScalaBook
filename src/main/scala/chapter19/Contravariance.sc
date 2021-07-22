class Publication(val title:String)
class Book(title:String) extends Publication(title)

object Library {
  val books:Set[Book] =
    Set(
      new Book("libro1"),
      new Book("libro2")
    )

  def printBookList(info: Book => AnyRef) = {
    for (book <- books) println(info(book))
  }
}

def getTitle(p:Publication) :String = p.title
Library.printBookList(getTitle)