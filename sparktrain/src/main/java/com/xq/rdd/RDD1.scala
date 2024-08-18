package com.xq.rdd

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

/**
 * @desc 读取数据
 * @author zhangxiaoqiong
 * @date 2022/10/09 17:03
 */
object RDD1 {

  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("CsvDemo")
    val session = SparkSession.builder().config(sparkConf).getOrCreate()

    // 返回rdd
    val rdd1 = session.sparkContext.textFile("./sparktrain/data/city_info.txt")
    rdd1.foreach(println)

    //返回dataframe
    val df1 = session.read.format("csv").option("sep","\t").load("./sparktrain/data/city_info.txt")
    df1.show()
    val df2 = session.read.format("csv").option("sep","\t").option("header","true").load("./sparktrain/data/city_info.txt")
    df2.show()

    session.close()

  }

}
