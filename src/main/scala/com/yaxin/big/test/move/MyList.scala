package com.yaxin.big.test.move

object MyList {
  
  def main(args : Array[String]) : Unit = {
    val data = List("spark","kafka");
    val data2 = List(1,2,3,4)
    
    
    println(data.isEmpty)
    println(data.head)
    println(data.tail)
    println(data.tail.head)
    
    
  }
}