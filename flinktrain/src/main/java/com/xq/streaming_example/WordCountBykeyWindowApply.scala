package com.xq.streaming_example

import org.apache.flink.api.common.functions.MapFunction
import org.apache.flink.streaming.api.scala.function.WindowFunction
import org.apache.flink.streaming.api.scala.{StreamExecutionEnvironment, _}
import org.apache.flink.streaming.api.windowing.assigners.TumblingProcessingTimeWindows
import org.apache.flink.streaming.api.windowing.time.Time
import org.apache.flink.streaming.api.windowing.windows.TimeWindow
import org.apache.flink.util.Collector

import java.util
import scala.collection.mutable.ListBuffer

object WordCountBykeyWindowApply {

  def main(args: Array[String]): Unit = {

    val env = StreamExecutionEnvironment.getExecutionEnvironment

    val socketData = env.socketTextStream("localhost", 9999)
    val windowCounts = socketData
      .flatMap(line => line.split(" "))
      .map { w => WordWithCount(w, 1) }
      .keyBy(s => s.word)
      .window(TumblingProcessingTimeWindows.of(Time.seconds(5)))
      .apply(
        new WindowFunction[WordWithCount,util.ArrayList[WordWithCount],String,TimeWindow] {
          @throws[Exception]
          def apply(key: String, window: TimeWindow, values: Iterable[WordWithCount], out: Collector[util.ArrayList[WordWithCount]]): Unit = {
            println("11111111")
            var listBuffer = new util.ArrayList[WordWithCount]
            for (t <- values) {
              listBuffer.add(t)
            }
            out.collect(listBuffer)
          }
        }
      )

    // print the results with a single thread, rather than in parallel
    windowCounts.print().setParallelism(2)

    env.execute("Socket Window WordCount")
  }

  /** Data type for words with count */
  case class WordWithCount(word: String, count: Long)

}