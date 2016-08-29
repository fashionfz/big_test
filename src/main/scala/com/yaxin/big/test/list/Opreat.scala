package com.yaxin.big.test.list

//list option

//map
//flatMap  map操作后合并成一个
//foreach
//filter
object Opreat {
  def main(args : Array[String]) : Unit = {
    val list = List(1,3,4,5,6,8,9);
    val list2= List(List(2,4,6),List(1,3,5));
    val map = list.map(_+1);
    println(map);
    val flatMap = list2.flatMap(_.map(_+1))
    println(flatMap)
    var sum = 0;
    list foreach(sum += _)
    println(sum)
    List(1,3,4,5,6,8,9) foreach(print)
    println(list.filter(_ % 2==0))
    
    //partition
    //find
    //takeWhile
    //dropWhile
    //span
    println("==========================")
    val list3 = List(8,3,6,1,9,4,7);
    println(list partition(_%2==0))
    println(list.find(_>3)) //只要找到一个就返回
    println(list3.takeWhile(_<5)) //只要遇到false就结束
    println(list3.dropWhile(_>4))
    println(list3 span(_<6))//要排序的才能达到预期，只要条件为false就结束
    //forall 所有元素都要满足才true
    //exists只要有一个满足就true
    val m = List(List(1,0,0),List(0,0,0),List(0,0,1))////矩阵
    println (m exists (x => x forall(_ == 0)))
    
    //foldLeft(z)(op)   foldRight(z)(op)
    val list4= List(1,3)
    println(list4.foldLeft(1)(_+_))
    println((2 /: list4)(_+_))
    println(list4.foldRight(6)(_-_))
    println("==========================")
    
    //半生对象
    List.apply(1,2,3)
    List.range(1,6)//左闭右开 1,2,3,4,5
    List.range(1,6,2)//步长2；1,3,5
    //zip unzip
    val xx = "abcde".toList zip List(1,2,3,4,5)
    println(xx)
    println(xx.unzip)
    //flatten
    println(List(List(1,3,5,7),List(2,4,6)).flatten)
    //concat
    println(List.concat(List(1,3,5,7),List(2,4,6)))
  }
}