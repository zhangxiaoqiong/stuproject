package com.xq.sql_example

import org.apache.spark.SparkConf
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}
/**
  * @desc xxx
  * @author zhangxiaoqiong
  * @date 2021/7/13 10:47
  */
object DataSets01 {

  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("spark sql basic example")

    val spark = SparkSession
      .builder()
      .config(sparkConf)
      .getOrCreate()

    import spark.implicits._
    // Encoders are created for case classes
    val caseClassDS = Seq(Person("Andy", 32)).toDS()
    caseClassDS.show()
//     +----+---+
//     |name|age|
//     +----+---+
//     |Andy| 32|
//     +----+---+

    // Encoders for most common types are automatically provided by importing spark.implicits._
    val primitiveDS = Seq(1, 2, 3).toDS()
    primitiveDS.show()
//    +-----+
//    |value|
//    +-----+
//    |    1|
//    |    2|
//    |    3|
//    +-----+
    primitiveDS.map(_ + 1).show()
//    |value|
//    +-----+
//    |    2|
//    |    3|
//    |    4|
//    +-----+

  }

  case class Person(name: String, age: Long)

}
