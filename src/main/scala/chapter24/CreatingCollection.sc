val ll = List(1,2,3,4,6,7)

List.fill(5,2)(2)
List.empty
List.concat(ll,ll)
List.tabulate(4)((x:Int) => x *2)
List.tabulate(4,5)((x:Int, y:Int) => x *y)
List.range(0,10,2)
List.iterate(1,10)(_ * 2)