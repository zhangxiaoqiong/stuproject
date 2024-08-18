package com.xq.streaming_example

import com.xq.streaming_example.WordCountBykeyWindowApply.WordWithCount
import org.apache.flink.api.common.functions.ReduceFunction
import org.apache.flink.streaming.api.functions.ProcessFunction
import org.apache.flink.streaming.api.scala.function.ProcessWindowFunction
import org.apache.flink.streaming.api.scala.{StreamExecutionEnvironment, _}
import org.apache.flink.streaming.api.windowing.assigners.TumblingProcessingTimeWindows
import org.apache.flink.streaming.api.windowing.time.Time
import org.apache.flink.streaming.api.windowing.windows.TimeWindow
import org.apache.flink.util.Collector

import scala.collection.mutable.ListBuffer

object WordCountBykeyReduce {

  def main(args: Array[String]): Unit = {

    val env = StreamExecutionEnvironment.getExecutionEnvironment

    val socketData = env.socketTextStream("localhost", 9999)
    val windowCounts = socketData
      .flatMap(line => line.split(" "))
      .map { w => WordWithCount(w, 1) }
      .keyBy(s => s.word).reduce( (t1,t2) => new WordWithCount(t1.word, t1.count+t2.count))

    // print the results with a single thread, rather than in parallel
    windowCounts.print().setParallelism(2)

    env.execute("Socket Window WordCount")
  }

  /** Data type for words with count */
  case class WordWithCount(word: String, count: Long)

}