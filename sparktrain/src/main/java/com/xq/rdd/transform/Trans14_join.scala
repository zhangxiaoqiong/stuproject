package com.xq.rdd.transform

import org.apache.spark.{SparkConf, SparkContext}

/**
  * @desc xxx
  * @author zhangxiaoqiong
  * @date 2021/6/11 10:03
  */
object Trans14_join {

  def main(args: Array[String]): Unit = {

    val mtaConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(mtaConf)

    // TODO groupBy
    val rdd = sc.makeRDD(List(("a",1),("b",2),("c",3),("d",4),("a",5),("b",6),("a",7),("b",8),("c",9)), 2)
    val rdd1 = sc.makeRDD(List(("a",1),("b",2),("c",3)))

    rdd.join(rdd1).collect().foreach(println)
//    (a,(1,1))
//    (a,(5,1))
//    (a,(7,1))
//    (b,(2,2))
//    (b,(6,2))
//    (b,(8,2))
//    (c,(3,3))
//    (c,(9,3))
    rdd1.join(rdd).collect().foreach(println)
//    (a,(1,1))
//    (a,(1,5))
//    (a,(1,7))
//    (b,(2,2))
//    (b,(2,6))
//    (b,(2,8))
//    (c,(3,3))
//    (c,(3,9))
    sc.stop()

  }


}
