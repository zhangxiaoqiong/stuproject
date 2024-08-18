package com.xq.rdd.transform

import org.apache.spark.{SparkConf, SparkContext}

/**
  * @desc xxx
  * @author zhangxiaoqiong
  * @date 2021/6/11 10:03
  */
object Trans09_distinct {

  def main(args: Array[String]): Unit = {

    val mtaConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(mtaConf)

    // TODO distinct
    val rdd = sc.makeRDD( List(1,2,3,4,5,6,7,8,9,1), 2 )

    rdd.distinct(2).collect().foreach(println)

    sc.stop()

  }


}
