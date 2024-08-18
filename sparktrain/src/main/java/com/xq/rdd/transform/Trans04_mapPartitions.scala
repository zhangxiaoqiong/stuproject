package com.xq.rdd.transform

import org.apache.spark.{SparkConf, SparkContext}

/**
  * @desc xxx
  * @author zhangxiaoqiong
  * @date 2021/6/11 10:03
  */
object Trans04_mapPartitions {

  def main(args: Array[String]): Unit = {

    val mtaConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(mtaConf)

    // TODO mapPartitions
    val rdd = sc.makeRDD( List(1,2,3,4,5), 2 )

    val mpP = rdd.mapPartitions( iter => {
      println("******")
      println(iter)
      iter
    })
    mpP.collect().foreach(println)

    sc.stop()

  }


}
