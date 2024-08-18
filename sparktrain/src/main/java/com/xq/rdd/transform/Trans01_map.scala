package com.xq.rdd.transform

import org.apache.spark.{SparkConf, SparkContext}

/**
  * @desc xxx
  * @author zhangxiaoqiong
  * @date 2021/6/11 10:03
  */
object Trans01_map {

  def main(args: Array[String]): Unit = {

    val mtaConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(mtaConf)

    // TODO map
    val rdd = sc.makeRDD( List(1,2,3,4,5,6), 2 )

    val mapRDD = rdd.map( x => {
      println("****")
      x*2
    })

    mapRDD.collect().foreach(println)

    sc.stop()

  }


}
