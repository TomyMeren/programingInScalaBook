import chapter25._

val xs = List(A, G, T, A)

RNA1.fromSeq(xs)
val rna1 = RNA1(A, G, T, A)
rna1.apply(1)
rna1.length
rna1.take(3)
rna1.last

RNA1(A,A,A,T).groups
RNA1(A,A,T).groups //16?
RNA1(A,T,A).groups //4
RNA1(T,A,A).groups

RNA1(T,T).groups


RNA1(A).groups
RNA1(T).groups
RNA1(G).groups
RNA1(U).groups
RNA1(A,T).groups
RNA1(T,T).groups
RNA1(G,T).groups
RNA1(U,T).groups
RNA1(A,G).groups
RNA1(T,G).groups
RNA1(G,G).groups
RNA1(U,G).groups
RNA1(A,U).groups
RNA1(T,U).groups
RNA1(G,U).groups
RNA1(U,U).groups

RNA1(U,U)(1)

//group.

/*
RNA1(G).groups
RNA1(U).groups


/**
val rna2 = RNA2(A, G, T, A)
rna2.take(3)

rna2.map { case A => T
case b => b
}

rna2 ++ rna2

rna2 map Base.toInt
rna2 ++ List("missing","data")

val rna = RNA(A, G, T, A)

rna.map { case A => T
case b => b
}

rna ++ rna

rna map Base.toInt
rna ++ List("missing","data")