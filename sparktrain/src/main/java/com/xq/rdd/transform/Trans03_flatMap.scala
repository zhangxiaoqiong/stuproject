package com.xq.rdd.transform

import org.apache.spark.{SparkConf, SparkContext}

/**
  * @desc xxx
  * @author zhangxiaoqiong
  * @date 2021/6/18 17:07
  */
object Trans03_flatMap {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("trans01")
    val sc = new SparkContext(sparkConf)

    val mkRDD = sc.makeRDD(List("how are you","how do you do","good good study","day day up"), 2)

    // TODO flatMap
    val resRDD = mkRDD.flatMap(s => {
      println("*****")
      s.split(" ")
    })
    resRDD.collect().foreach(println)

    sc.stop()
  }

}
