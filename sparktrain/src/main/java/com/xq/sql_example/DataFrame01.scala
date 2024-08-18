package com.xq.sql_example

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

/**
  * @desc xxx
  * @author zhangxiaoqiong
  * @date 2021/7/13 10:13
  */
object DataFrame01 {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("spark sql basic example")
    val session = SparkSession.builder().config(sparkConf).getOrCreate()

    // DataFrame
    val df = session.read.json("./sparktrain/data/stu.json")
    df.show()

    // 操作逻辑1：dsl
    import session.implicits._
    df.filter( $"age">20).show()

    // 操作逻辑2：sql
    df.createOrReplaceTempView("student")
    val sqlDF = session.sql("SELECT * FROM student")
    sqlDF.show()
    df.createGlobalTempView("student") //global temporary view
    val sqlDF1 = session.newSession().sql("SELECT * FROM global_temp.student")
    sqlDF1.show()

    // close
    session.close()

  }

}
