val range = (271973 to 785961).toList

def hasRepetitionNoDecrease(i : Int) : Boolean = {
    val list = i.toString.map(_.asDigit).sliding(2).toList
    list.exists(x => x(0) == x(1)) && list.forall(x => x(0) <= x(1))

}

def noTripleOrMore(i : Int) : Boolean = {
    val list = i.toString.map(_.asDigit).sliding(2).toList
    val filtered = list.filter(x => x(0) == x(1)).flatten.distinct
    val parsedList = i.toString.map(_.asDigit).toList
    
    parsedList.exists(x => filtered.contains(x) &&  parsedList.groupBy(identity).mapValues(_.size)(x) ==2)

}

range.filter(x => hasRepetitionNoDecrease(x) && noTripleOrMore(x) ).size

