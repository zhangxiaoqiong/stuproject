package com.xq.rdd.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @desc xxx
  * @author zhangxiaoqiong
  * @date 2021/6/11 10:03
  */
object Trans08_intersection {

  def main(args: Array[String]): Unit = {

    val mtaConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(mtaConf)

    // TODO intersection
    val rdd = sc.makeRDD( List(1,2,3,4,5,6,7,8,9), 2 )
    val rdd1 = sc.makeRDD( List(2,3,4), 2 )

    val value = rdd.intersection(rdd1)
    value.collect().foreach(println)

    sc.stop()

  }


}
