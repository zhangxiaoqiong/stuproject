package com.xq.rdd.transform

import org.apache.spark.{SparkConf, SparkContext}

/**
  * @desc xxx
  * @author zhangxiaoqiong
  * @date 2021/6/11 10:03
  */
object Trans11_reduceByKey {

  def main(args: Array[String]): Unit = {

    val mtaConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(mtaConf)

    // TODO reduceBy
    val rdd = sc.makeRDD(List(("a",1),("b",2),("c",3),("d",4),("a",5),("b",6),("a",7),("b",8),("c",9)), 2)

    rdd.reduceByKey( (x1,x2) => {
      println("------")
      x1 + x2
    } ).collect().foreach(println)
//    ------
//    ------

//    ------
//    ------
//    ------

//    (d,4)
//    (b,16)
//    (a,13)
//    (c,12)

    sc.stop()

  }


}
