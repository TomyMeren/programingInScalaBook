object Coverter {
  val exchageRate:Map[String,Map[String,Double]] = Map(
    "USD" -> Map("USD" -> 1.0   , "EUR" -> 0.7596,
      "JPY" -> 1.211 , "CHF" -> 1.223),
    "EUR" -> Map("USD" -> 1.316 , "EUR" -> 1.0   ,
      "JPY" -> 1.594 , "CHF" -> 1.623),
    "JPY" -> Map("USD" -> 0.8257, "EUR" -> 0.6272,
      "JPY" -> 1.0   , "CHF" -> 1.018),
    "CHF" -> Map("USD" -> 0.8108, "EUR" -> 0.6160,
      "JPY" -> 0.982 , "CHF" -> 1.0  )
  )
}

abstract class CurrencyZone {
  type Currency <: AbstractCurrency
  def make(l: Long): Currency
  val CurrencyUnit:Currency

  abstract class AbstractCurrency {
    val amount: Long
    def designation: String

    private def decimal(n :Long):Int =
      if (n == 1)  0
      else 1 + decimal(n/10)

    override def toString = ((amount.toDouble/CurrencyUnit.amount)
      formatted (s"%.${decimal(CurrencyUnit.amount)}f")) +
      " " +designation

    def +(that: Currency): Currency = make(this.amount + that.amount)
    def *(num: Double): Currency = make((this.amount * num).toLong)
    def from (other:CurrencyZone#AbstractCurrency):Currency = {
      make(Math.round(other.amount.toDouble *
        Coverter.exchageRate(other.designation)(this.designation)))
    }
  }
}



object US extends CurrencyZone {
  abstract class Dollar extends AbstractCurrency {
    def designation: String = "USD"
  }

  type Currency = Dollar
  def make(l: Long) = new Dollar {
    val amount = l
  }
  val Cents = make(1)
  val Dollar = make(100)
  val CurrencyUnit:Currency = Dollar
}

US.make(5)
US.make(504)
US.make(560)
US.make(500)

object Europe extends CurrencyZone {
  abstract class Euro extends AbstractCurrency {
    def designation: String = "EUR"
  }

  type Currency = Euro
  def make(l: Long) = new Euro {
    val amount = l
  }
  val Cents = make(1)
  val Euro = make(100)
  val CurrencyUnit:Currency = Euro
}

val eur1 = Europe.make(500)

object Japan extends CurrencyZone {
  abstract class Yen extends AbstractCurrency {
    def designation: String = "JPY"
  }

  type Currency = Yen
  def make(l: Long) = new Yen {
    val amount = l
  }
  val Yen = make(1)
  val CurrencyUnit:Currency = Yen
}

val trans1 =Japan.Yen.from(US.Dollar) * 100

(Europe.Euro from trans1) + eur1