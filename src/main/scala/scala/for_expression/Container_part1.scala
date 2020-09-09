package scala.for_expression

case class Container_1[A](elems:A*) {

  private val storage=scala.collection.mutable.ArrayBuffer[A]()

  storage ++= elems

  def foreach(f:A=>Unit): Unit ={
    storage.foreach(f)
  }

}

object Container_part1 {

  def main(args: Array[String]): Unit = {

    val container=Container_1(1,2,3)

    for(data <- container) println(data)
  }
}
