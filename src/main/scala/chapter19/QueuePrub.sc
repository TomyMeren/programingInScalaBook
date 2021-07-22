import chapter19.{Queue, QueueVarian}
/*

val q = new Queue[Int](Nil,Nil)
val q1 = q.enqueue(1).enqueue(2).enqueue(3).enqueue(4)
val q5 = new Queue(List("a","b"))
*/
val q4:Queue[Int] = Queue(7,8,9,10) enqueue 11

q4.head
q4.tail

val q5:Queue[Any] = Queue(7,8,9,10) enqueue 11

def func(a:Queue[Any]) = {}
def funcList(a:List[Any]) = {}

func(q4)
funcList(List(1,2,3))

val q:QueueVarian[Int] = new QueueVarian(List(1,2,3),Nil)

val q1 = q.enqueue(4)
q1.