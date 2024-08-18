package com.xq.rdd.transform

import org.apache.spark.{SparkConf, SparkContext}

/**
  * @desc xxx
  * @author zhangxiaoqiong
  * @date 2021/6/18 16:58
  */
object Trans05_mapPartitionsWithIndex {

  def main(args: Array[String]): Unit = {

    val mtaConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(mtaConf)

    // TODO mapPartitionsWithIndex
    val rdd = sc.makeRDD( List(1,2,3,4,5), 2 )

    val mpP = rdd.mapPartitionsWithIndex( (idx, iter) => {
      println("******")
      println(idx)
      iter.map( x => {(idx, x*2)} )
    })
    mpP.collect().foreach(println)

    sc.stop()

  }

}
