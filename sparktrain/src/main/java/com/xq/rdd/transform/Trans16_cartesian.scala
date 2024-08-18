package com.xq.rdd.transform

import org.apache.spark.{SparkConf, SparkContext}

/**
  * @desc xxx
  * @author zhangxiaoqiong
  * @date 2021/6/11 10:03
  */
object Trans16_cartesian {

  def main(args: Array[String]): Unit = {

    val mtaConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(mtaConf)

    // TODO groupBy
    val rdd = sc.textFile("/input/apache.log")

    rdd.map( line => {})

    sc.stop()

  }


}
