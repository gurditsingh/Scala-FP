package scala.MultipleParamGroup

object Wheely {

  def wheely(expr: => Boolean)(block: => Unit): Unit = {
    while (expr) {
      block
    }
  }


  def main(args: Array[String]): Unit = {

    println("***Custom While Loop***")
    var i = 0
    wheely( i < 3){
      println("i : "+ i)
      i+=1
    }
    println("*"*20)
  }

}
