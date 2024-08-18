package com.xq.core_example

import org.apache.spark.{SparkConf, SparkContext}

/**
  * @desc xxx
  * @author zhangxiaoqiong
  * @date 2021/6/22 18:11
  */
object HotProduct {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("HotProduct")
    val sc = new SparkContext(sparkConf)

    val textRDD = sc.textFile("./sparktrain/data/user_visit_action.txt",3)
    val mapRDD = textRDD.map(line => {
      val slst = line.split("_")
      slst
    })

    mapRDD.filter(x => x(6) != "-1")
      .map( x => {(x(6),1)})
      .reduceByKey((v1, v2) => {v1+v2})
      .sortBy(s => {s._2})
//      .reduceByKey((v1, v2) => {v1+v2}, 3)
//      .sortBy(s => {s._2} ,false, 3)
      .collect().foreach(s => println(s))
  }

}
