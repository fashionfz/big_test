package com.yaxin.big.test.move

//模式匹配
object Match {
  def main(args : Array[String]) : Unit = {
    
    // match 
    val data = 3;
    data match {
      case 1 => {
        
      }
      case v => println(v);
    }
    
    //type match
    def match_type(input : Any) : Unit = {
      input match {
        case p : Int => println("int");
        case p : String => println("string");
        case _ => println("other")
      }
    }
    match_type("xx");
    
    // Array match
    def match_array(input : Any) : Unit = {
      input match {
        case Array(0) => println(0);
        case Array(x) => println(x);
        case Array(x,y) => println(x+""+y);
        case Array(0,_*) => println(0+"-")
      }
    }
    match_array(Array(1,2));
    
    //List match
    def match_list(input : Any) : Unit = {
      input match {
        case 0 :: Nil => println("one item");
        case x :: y => println("two item " + x + ""+y)
        case 0 :: tail => println("many item")
        case _ => println("not list")
      }
    }
    match_list(List(1,2))
    
    //match tuple
    def match_tuple(input : Any) : Unit = {
      input match {
        case (0,_) => println("first is 0")
        case (x,0) => println("send is 0")
        case _ => println("other")
      }
    }
    match_tuple((33,0))
    
    
    //嵌套case class
    
    abstract class Item;
    case class Booke(description : String, price : Double) extends Item;
    case class More(description : String, price : Double, items : Item*) extends Item;
    
    def match_inner(input : Item) : Unit = {
      input match{
        case More(_, _, bk @ Booke(_, _), thor @ _*) => println(bk.price)
        case More(_, _, Booke(dsec, _), _*) => println(dsec);
        case _ => println("other")
      }
    }
    
    
    var map = Map("xxx"->2,"uu"->3)
    map.get("xxx") match{
      case Some(score) => println(score)
      case None => println("no")
    }
  }
}