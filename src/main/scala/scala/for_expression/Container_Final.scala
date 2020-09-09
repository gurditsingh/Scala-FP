package scala.for_expression


import scala.collection.mutable.ArrayBuffer
case class Container[A](elems:A*) {

  private val storage=ArrayBuffer[A]()

  storage ++= elems

  def foreach(f:A=>Unit): Unit ={
    storage.foreach(f)
  }

  def map[B](f:A=>B):Container[B]={
    val mapped=storage.map(f)
    Container(mapped:_*)
  }

  def withFilter(f:A=>Boolean):Container[A]={
    val filtered=storage.filter(f)
    Container(filtered:_*)
  }

  def flatMap[B](f:A=>Container[B]):Container[B]={
    val mapped:Container[Container[B]]=map(f)
    flatten(mapped)
  }

  def flatten[B](nested: Container[Container[B]]): Container[B] ={
    val internal = ArrayBuffer[B]()
    for(c <- nested){
      for(cc <- c){
        internal += cc
      }
    }
    Container(internal:_*)
  }
}


object Container_Final {


  def main(args: Array[String]): Unit = {

    val container=Container(Container(1,2),Container(3,4))

    for{
      map <- container
      flat <- map
      if flat > 2
    } yield  println(flat)



  }

}
