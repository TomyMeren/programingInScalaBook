package chapter25.tomy

abstract class BaseT

case object AT extends BaseT
case object BT extends BaseT
case object CT extends BaseT
case object DT extends BaseT

object BaseT {
  def getBase: Int => BaseT = Array(AT, BT, CT, DT)
  def getInd: BaseT => Int = Map(AT -> 0, BT -> 1, CT -> 2, DT -> 3)
}
