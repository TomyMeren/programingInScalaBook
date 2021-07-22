case class Person(name: String,
  isMale: Boolean,
  children: Person*)

val lara = Person("Lara", false)
val bob = Person("Bob", true)
val julie = Person("Julie", false, lara, bob)
val persons = List(lara, bob, julie)

persons.withFilter(p => !p.children.isEmpty && !p.isMale).flatMap(p =>
  p.children.map(c => (p.name, c.name)))

for (p <- persons;
     sexo = p.isMale
     if !sexo;
     c <- p.children
     ) yield (p.name, c.name)