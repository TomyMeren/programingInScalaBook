val capitals =
  Map("france" -> "pagi", "spain" -> "madrid", "England" -> "London")

val a = capitals get "france"
val b = capitals get "meh"

def show(x:Option[String]) = x match {
  case Some(e) => e
  case none => "?"
}

show(a)
show(b)