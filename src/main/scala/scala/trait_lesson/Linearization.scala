package scala.trait_lesson

trait A{
  def name:String
}

trait B extends A{
  override def name: String = "I'm B"
}

trait C extends A{
  override def name: String = "I'm C"
}

class D extends B with C{
  override def name: String = super.name
}

object Linearization {
  def main(args: Array[String]): Unit = {
    val d=new D
    println(d.name)
  }
}
