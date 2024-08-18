package com.xq.rdd

import org.apache.spark.{SparkConf, SparkContext}

/**
  * @desc xxx
  * @author zhangxiaoqiong
  * @date 2021/6/11 10:03
  */
object Mta1 {

  def main(args: Array[String]): Unit = {

    val mtaConf = new SparkConf().setMaster("local").setAppName("mta1")

    val sc = new SparkContext(mtaConf)

    val rdd = sc.textFile("./input/test1.txt")

    val res = rdd.flatMap(s => {
      s.split(" ")
    })
      .map(w => {
        (w, 1)
      })
      .reduceByKey((n1, n2) => {
        n1 + n2
      })
//    res.collect().foreach(println)
    res.saveAsTextFile("./output")

    sc.stop()

  }


}
