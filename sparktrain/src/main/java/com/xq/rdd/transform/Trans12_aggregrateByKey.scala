package com.xq.rdd.transform

import org.apache.spark.{SparkConf, SparkContext}

/**
  * @desc xxx
  * @author zhangxiaoqiong
  * @date 2021/6/11 10:03
  */
object Trans12_aggregrateByKey {

  def main(args: Array[String]): Unit = {

    val mtaConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(mtaConf)

    // TODO aggregateByKey
    val rdd = sc.makeRDD(List(
      ("a",1),("b",2),("c",3),("d",4),
      ("a",5),("b",6),("a",7),("b",8),("c",9)
    ), 2)

    rdd.aggregateByKey(0)(
      (v1,v2) => {
        println("1111111111")
        math.max(v1,v2)},  //分区内
      (v3,v4) => {
        println("2222222222")
        v3+v4}   //分区间
    ).collect().foreach(println)
//    (d,4)
//    (b,10)
//    (a,8)
//    (c,12)

//    rdd.aggregateByKey(0)(
//      (v1,v2) => {v1+v2},  //分区内
//      (v3,v4) => {v3+v4}   //分区间
//    ).collect().foreach(println)

    sc.stop()

  }


}
