package com.zxq

import scala.collection.mutable

object BaseTest {

  def main(args: Array[String]): Unit = {

    // 方法
    val a1 = 3
    val b1 = 4
    println("addInt:" + addInt(a1,b1))

    // 字符串
    val greeting: String = "Hello!"
    println(greeting)

    val buf = new StringBuilder()
    buf += 'a'
    buf ++= "bcdef"
    println("bus is : " + buf.toString())

    var len = buf.length()
    println( "String Length is : " + len );

    // 数组
    var myList = Array(1.9, 2.9, 3.4, 3.5)
    // 输出所有数组元素
    for ( x <- myList ) {
      println( x )
    }
    // 计算数组所有元素的总和
    var total = 0.0;
    for ( i <- 0 to (myList.length - 1)) {
      total += myList(i);
    }
    println("总和为 " + total);
    // 查找数组中的最大元素
    var max = myList(0);
    for ( i <- 1 to (myList.length - 1) ) {
      if (myList(i) > max) max = myList(i);
    }
    println("最大值为 " + max);


    // List集合
    var a = List( (1,"hh") )
    println(a)
    println(a :+ (2,"gg"))


  }

  /**
   * 两个整数相加
   * @param a
   * @param b
   * @return
   */
  def addInt( a:Int, b:Int ) : Int = {
    var sum:Int = 0
    sum = a + b

    return sum
  }

}
