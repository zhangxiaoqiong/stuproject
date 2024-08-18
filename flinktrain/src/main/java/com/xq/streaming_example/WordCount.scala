package com.xq.streaming_example

import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
import org.apache.flink.streaming.api.scala._

/**
 *
 */
object WordCount {

  def main(args: Array[String]): Unit = {

    val env = StreamExecutionEnvironment.getExecutionEnvironment

    val socketData = env.socketTextStream("localhost", 9999)
    socketData
      .flatMap(line => line.split(" "))
      .map( w => (w, 1))
      .keyBy(0)
      .sum(1)
      .print()

    print(env.getExecutionPlan)
    env.execute("wordcount")

  }

}