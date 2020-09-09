package scala.for_expression

case class Container_3[A](elems:A*) {

  private val storage=scala.collection.mutable.ArrayBuffer[A]()

  storage ++= elems

  def foreach(f:A=>Unit): Unit ={
    storage.foreach(f)
  }

  def map[B](f:A=>B):Container_3[B]={
    val mapped=storage.map(f)
    Container_3(mapped:_*)
  }

  def withFilter(f:A=>Boolean):Container_3[A]={
    val filtered=storage.filter(f)
    Container_3(filtered:_*)
  }

}

object Container_part3 {

  def main(args: Array[String]): Unit = {
    val container_3=Container_3(1,2,3)
    for{
      data <- container_3
      if data > 2
    } yield println(data)
  }

}
