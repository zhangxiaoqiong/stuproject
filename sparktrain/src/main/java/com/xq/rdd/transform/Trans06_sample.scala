package com.xq.rdd.transform

import org.apache.spark.{SparkConf, SparkContext}

/**
  * @desc xxx
  * @author zhangxiaoqiong
  * @date 2021/6/11 10:03
  */
object Trans06_sample {

  def main(args: Array[String]): Unit = {

    val mtaConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(mtaConf)

    // TODO sample
    val rdd = sc.makeRDD( List(1,2,3,4,5,6,7,8,9), 2 )

//    val mpP = rdd.sample(false, 0.2)
    val mpP = rdd.sample(true, 0.2)
    mpP.collect().foreach(println)

    sc.stop()

  }


}
