package com.xq.streaming_example

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * @desc xxx
  * @author zhangxiaoqiong
  * @date 2021/7/2 15:37
  */
object WordCount {

  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("streaming wordcount")

    val ssc = new StreamingContext(sparkConf, Seconds(3))

    val lines = ssc.socketTextStream("192.168.186.130", 9999)

    val reduceResult = lines.flatMap( line => { line.split(" ") }).map( w => {(w,1)}).reduceByKey( (v1,v2) => { v1+v2 })

    reduceResult.print()

    ssc.start()
    ssc.awaitTermination()
  }

}
