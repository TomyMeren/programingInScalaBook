(List(10,20,30), List(3,4,5)).zipped.map(_ * _)

(List("abc","de"), List(3,2)).zipped.forall(_.length == _)

(List("abc","de"), List(3,2)).zipped.exists(_.length != _)

