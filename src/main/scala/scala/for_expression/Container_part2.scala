package scala.for_expression

case class Container_2[A](elems:A*) {

  private val storage=scala.collection.mutable.ArrayBuffer[A]()

  storage ++= elems

  def foreach(f:A=>Unit): Unit ={
    storage.foreach(f)
  }

  def map[B](f:A=>B):Container_2[B]={
    val mapped=storage.map(f)
    Container_2(mapped:_*)
  }

}

object Container_part2 {

  def main(args: Array[String]): Unit = {

    val container_2 =Container_2(1,2,3)

    for{
      data <- container_2
      transform = data * 2
    } yield println(transform)


  }
}
