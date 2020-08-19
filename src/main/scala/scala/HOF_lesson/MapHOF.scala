package scala.HOF_lesson

object MapHOF {

  def map1(f: Int=>Int,list:List[Int]):List[Int] = {
     for (v <- list ) yield (f(v))
  }

  def map2[A](f: Int=>A , list:List[Int]):List[A] = {
    for (v <- list ) yield (f(v))
  }

  def map3[A,B](f: B=>A , list:List[B]):List[A] = {
    for (v <- list ) yield (f(v))
  }


  def main(args: Array[String]): Unit = {
    println(":Taking Int Type as argument:")
    val list = List(1,2,3,4,5)
    def toPow(x:Int): Int={
      x * x
    }
    println("Input: "+ list)
    println("Output: "+ map1(toPow,list))
    println("*"*30)

    println(":Taking One Output Type as argument:")
    val intList = List(1,2,3,4,5)
    def toFloat(x:Int): Float={
      x.toFloat
    }
    println("Input: "+ intList)
    println("Output: "+map2[Float](toFloat,intList))
    println("*"*30)

    println(":Taking Different Types as argument:")
    val stringList=List("1a","2b","3c","4d")
    def subStringInt(x:String): Int ={
      x.substring(0,1).toInt
    }
    println("Input: "+ stringList)
    println("Output: "+map3[Int,String](subStringInt,stringList))
    println("*"*30)

  }

}
