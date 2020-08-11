package scala.trait_lesson

object ModifyFunctionality {

  def main(args: Array[String]): Unit = {

    class Jaguar(modelName: String)
      extends SportsCar(modelName)
        with Spoiler

    class BMW(modelName: String)
      extends OrdinaryCar(modelName)
        with TurboCharger


    val jaguar = new Jaguar("jaguar j8")
    val bmw = new BMW("BMW s2")

    println(jaguar.topSpeed)
    println(bmw.topAcceleration)
  }
}

abstract class Car{
  def model:String
  def topSpeed:Int
  def topAcceleration:Int
}

class OrdinaryCar(override val model:String) extends Car{
  override def topSpeed: Int = 200
  override def topAcceleration: Int = 8000
}

class SportsCar(override val model:String) extends Car{
  override def topSpeed: Int = 300
  override def topAcceleration: Int = 22000
}

trait Spoiler extends Car{
  abstract override def topSpeed: Int = (super.topSpeed * 1.2).toInt
}

trait TurboCharger extends Car{
  abstract override def topAcceleration: Int = (super.topAcceleration * 1.5).toInt
}