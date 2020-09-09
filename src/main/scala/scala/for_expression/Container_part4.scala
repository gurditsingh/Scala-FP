package scala.for_expression

import scala.collection.mutable.ArrayBuffer

case class Container_4[A](elems:A*) {

  private val storage=scala.collection.mutable.ArrayBuffer[A]()

  storage ++= elems



  def foreach(f:A=>Unit): Unit ={
    storage.foreach(f)
  }

  def map[B](f:A=>B):Container_4[B]={
    val mapped=storage.map(f)
    Container_4(mapped:_*)
  }

  def withFilter(f:A=>Boolean):Container_4[A]={
    val filtered=storage.filter(f)
    Container_4(filtered:_*)
  }

  def flatMap[B](f:A=>Container_4[B]):Container_4[B]={
    val mapped:Container_4[Container_4[B]]=map(f)
    flattenNew(mapped)
  }

  def flattenNew[B](container_4: Container_4[Container_4[B]]): Container_4[B] ={
   val internal = ArrayBuffer[B]()
    for(c <- container_4){
      for(cc <- c){
        internal += cc
      }
    }
    Container_4(internal:_*)
  }
}

object Container_part4 {

  def main(args: Array[String]): Unit = {

    val container_4=Container_4(Container_4(1,2),Container_4(3,4))
    for{
      data <- container_4
      flat <- data
      out = flat
    }  yield println(out)
  }
}
