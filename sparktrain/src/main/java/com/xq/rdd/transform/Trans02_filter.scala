package com.xq.rdd.transform

import org.apache.spark.{SparkConf, SparkContext}

/**
  * @desc xxx
  * @author zhangxiaoqiong
  * @date 2021/6/11 10:03
  */
object Trans02_filter {

  def main(args: Array[String]): Unit = {

    val mtaConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(mtaConf)

    // TODO filter
    val rdd = sc.makeRDD( List(1,2,3,4,5), 2 )

    val mapRDD = rdd.filter( x => {
      println("****")
      x>2
    })

    mapRDD.collect().foreach(println)

    sc.stop()

  }


}
