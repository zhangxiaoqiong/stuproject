package com.xq.sql_example

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

/**
  * @desc xxx
  * @author zhangxiaoqiong
  * @date 2021/7/13 10:13
  */
object DataFrame02 {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("spark sql basic example")
    val session = SparkSession.builder().config(sparkConf).getOrCreate()

    // RDD <=> DataFrame
    val mkRDD = session.sparkContext.makeRDD( List((1, "zhangsan", 30), (2, "lisi", 40),(3, "zhangxiao", 18)), 2 )
    import session.implicits._
    val df = mkRDD.toDF("id","name","age")
    df.show()
//    +---+---------+---+
//    | id|     name|age|
//    +---+---------+---+
//    |  1| zhangsan| 30|
//    |  2|     lisi| 40|
//    |  3|zhangxiao| 18|
//    +---+---------+---+
    val newRDD = df.rdd
    newRDD.collect().foreach(println)
//      [1,zhangsan,30]
//      [2,lisi,40]
//      [3,zhangxiao,18]

    // DataSets <=> DataFrame
    val ds = Seq((1, "zhangsan", 30), (2, "lisi", 40),(3, "zhangxiao", 18)).toDS()
    val df1 = ds.toDF("id","name","age")
    df1.show()
//    +---+---------+---+
//    | id|     name|age|
//    +---+---------+---+
//    |  1| zhangsan| 30|
//    |  2|     lisi| 40|
//    |  3|zhangxiao| 18|
//    +---+---------+---+
    val ds2 = df1.as[Person]
    ds2.show()
//    | id|     name|age|
//    +---+---------+---+
//    |  1| zhangsan| 30|
//    |  2|     lisi| 40|
//    |  3|zhangxiao| 18|
//    +---+---------+---+


    // close
    session.close()

  }

  case class Person(id: Long, name: String, age: Long)
}
