package com.yaxin.big.test.move

//提取器
object Extractor {
  
    //case class    默认传递的是val,适合消息传递
  ///case object  全局唯一单利对象
  abstract class Persion;
  case class Stduent(age : Int) extends Persion;
  case class Woker(age : Int, shouru : Double) extends Persion;
  
  def main(args : Array[String]) : Unit = {
    val parrten = "([0-9]+) ([a-z]+)".r
    "2323 xxx" match{
      case parrten(x,y) =>println(x+"-"+y)
    }
    
    
    def match_class(item : Persion) : Unit = {
      item match {
        case Stduent(age) => println(age);
        case Woker(_,shouru) => println(shouru);
        case _ => println("other")
      }
    }
  }
  
  
  val woker = Woker(1,1);
  val woker2 = woker.copy(shouru=4);
  
  

  
}