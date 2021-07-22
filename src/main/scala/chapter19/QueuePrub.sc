import chapter19.Queue
/*

val q = new Queue[Int](Nil,Nil)
val q1 = q.enqueue(1).enqueue(2).enqueue(3).enqueue(4)
val q5 = new Queue(List("a","b"))
*/
val q4:Queue[Int] = Queue(7,8,9,10) enqueue 11

q4.head
q4.tail

//val q5:Queue[AnyRef] = Queue(7,8,9,10) enqueue 11

def func(a:Queue[AnyRef]) = {}
def funcList(a:List[AnyRef]) = {}

func(q4)
funcList(List(1,2,3))

q4:Queue[Int]
