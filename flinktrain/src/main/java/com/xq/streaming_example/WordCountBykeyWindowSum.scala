package com.xq.streaming_example

import org.apache.flink.streaming.api.scala.{StreamExecutionEnvironment, _}
import org.apache.flink.streaming.api.windowing.assigners.TumblingProcessingTimeWindows
import org.apache.flink.streaming.api.windowing.time.Time

object WordCountBykeyWindowSum {

  def main(args: Array[String]): Unit = {

    val env = StreamExecutionEnvironment.getExecutionEnvironment

    val socketData = env.socketTextStream("localhost", 9999)
    val windowCounts = socketData
      .flatMap(line => line.split(" "))
      .map { w => WordWithCount(w, 1) }
      .keyBy( s => s.word )
      .window(TumblingProcessingTimeWindows.of(Time.seconds(5)))
      .sum("count")

    // print the results with a single thread, rather than in parallel
    windowCounts.print().setParallelism(1)

    env.execute("Socket Window WordCount")
  }

  /** Data type for words with count */
  case class WordWithCount(word: String, count: Long)

}