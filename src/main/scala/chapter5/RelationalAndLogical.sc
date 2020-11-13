1 > 2
1.0 >= 1.0
3.5f >= 3.6f
!true
'a' >= 'A'
'a' + 0
'A' + 0

true || !true
true&& !true

def salt() = {println("salt"); false}

def pepper() = {println("pepper"); true}

pepper || salt
pepper && salt()

salt && pepper
salt || pepper

salt & pepper