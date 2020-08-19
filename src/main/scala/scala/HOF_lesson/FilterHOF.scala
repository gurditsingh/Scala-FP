package scala.HOF_lesson

object FilterHOF {


  def filter1(p: Int=>Boolean,list: List[Int]):List[Int]={
    def loop(inList:List[Int],outList:List[Int],p: Int=>Boolean): List[Int] = inList match {
      case List() => outList
      case h::t =>
        if(p(h)) loop(t, outList++List(h),p)
        else  loop(t,outList,p)
    }
    loop(list,List(),p)
  }

  def filter2[A](p: A=>Boolean,list: List[A]):List[A]={
    def loop[A](inList:List[A],outList:List[A],p: A=>Boolean): List[A] = inList match {
      case List() => outList
      case h::t =>
        if(p(h)) loop(t, outList++List(h),p)
        else  loop(t,outList,p)
    }
    loop(list,List(),p)
  }


  def main(args: Array[String]): Unit = {

    println(":Taking Int Type as argument:")
    val list = List(1,2,3,4,5)
    def isEven(x:Int):Boolean={
      x % 2 == 0
    }
    println("Input: "+ list)
    println("Output: "+ filter1(isEven,list))
    println("*"*30)

    println(":Taking Different Types as argument:")
    val stringList=List("sam","jone","bert","cart","joy")
    def containE(x:String): Boolean ={
      x.contains("e")
    }
    println("Input: "+ stringList)
    println("Output: "+filter2[String](containE,stringList))
    println("*"*30)
  }

}
