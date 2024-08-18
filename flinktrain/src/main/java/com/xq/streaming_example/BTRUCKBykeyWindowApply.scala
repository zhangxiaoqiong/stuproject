package com.xq.streaming_example

import java.util
import java.util.{ArrayList, Iterator, List, Properties}

import com.alibaba.fastjson.JSON
import com.xq.streaming_example.bean.BTrack
import org.apache.flink.api.common.functions.MapFunction
import org.apache.flink.api.common.serialization.SimpleStringSchema
import org.apache.flink.api.java.tuple.Tuple2
import org.apache.flink.streaming.api.scala.function.WindowFunction
import org.apache.flink.streaming.api.scala.{StreamExecutionEnvironment, _}
import org.apache.flink.streaming.api.windowing.assigners.TumblingProcessingTimeWindows
import org.apache.flink.streaming.api.windowing.time.Time
import org.apache.flink.streaming.api.windowing.windows.TimeWindow
import org.apache.flink.util.Collector
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer

object BTRUCKBykeyWindowApply {

  def main(args: Array[String]): Unit = {

    val env = StreamExecutionEnvironment.getExecutionEnvironment
    // flink的checkpoint的时间间隔
    env.enableCheckpointing(5000)
    // topic
    val topic_name = "b_track"
    val kfkProperties = new Properties
    kfkProperties.setProperty("bootstrap.servers", "10.74.20.52:9092")
    kfkProperties.getProperty("group.id", "zxq_test2")
    // kafka数据源
    val socketData = env.addSource(
      new FlinkKafkaConsumer(topic_name, new SimpleStringSchema, kfkProperties)
        .setCommitOffsetsOnCheckpoints(true)
        .setStartFromEarliest
      //                .setStartFromLatest()
      //                .setStartFromGroupOffsets()
    )

    val windowCounts = socketData
      .map {
        new MapFunction[String, Tuple2[String, String]]() {
          @throws[Exception]
          override def map(jsonObject: String): Tuple2[String, String] = {
            val bTrack = JSON.parseObject(jsonObject, classOf[BTrack])
            val tuple = new Tuple2[String, String]
            val hbaseId = bTrack.getHbaseId
            tuple.setField(hbaseId.substring(hbaseId.length - 1), 0)
            tuple.setField(jsonObject, 1)
            tuple
          }
        }
      }
      .keyBy(s => s.f0)
      .window(TumblingProcessingTimeWindows.of(Time.seconds(5)))
      .apply(
          new WindowFunction[Tuple2[String, String], util.ArrayList[String], String, TimeWindow]() {
            @throws[Exception]
            override def apply(key: String, window: TimeWindow, values: Iterable[Tuple2[String, String]], out: Collector[util.ArrayList[String]]): Unit = {
              val dataOnes = new util.ArrayList[String]
              val iterator = values.iterator
              while (iterator.hasNext) dataOnes.add(iterator.next.f1.toString)
              if (dataOnes.size > 0) out.collect(dataOnes)
            }
          }
      )

    // print the results with a single thread, rather than in parallel
    windowCounts.print().setParallelism(2)

    env.execute("Socket Window WordCount")
  }

}