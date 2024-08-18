package com.xq.other_example

import org.apache.spark.SparkConf
import org.apache.spark.sql.functions.col
import org.apache.spark.sql.{SaveMode, SparkSession}

/**
  * @desc xxx
  * @author zhangxiaoqiong
  * @date 2023/5/25 23:13
  */
object InsertClickhouse {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("spark sql basic example")
    val session = SparkSession.builder().config(sparkConf).getOrCreate()

    // DataFrame
    val df = session.read
      .csv("./sparktrain/data/array_tuple_test.csv")
      .toDF("id","name","Info_list")
    df.show()
    df.printSchema()

    //注册一个函数
    session.udf.register("replaceStr1", (str:String) => str )

    df.createGlobalTempView("tb2") //global temporary view
//    val sqlDF1 = session.sql("SELECT id,name,Info_list FROM global_temp.tb2")
    val sqlDF1 = session.sql("SELECT id,name,replaceStr1(Info_list) as Info_list FROM global_temp.tb2")
    sqlDF1.show()


    val prop = new java.util.Properties
//    prop.setProperty("user", "default")
//    prop.setProperty("password", "123456")
    prop.setProperty("driver", "ru.yandex.clickhouse.ClickHouseDriver")


//    val readDataDf = session
//      .read
//      .jdbc("jdbc:clickhouse://127.0.0.1:8123/xqtestdb",
//        "tb2",prop)
//    readDataDf.show()

    val tablename = s"(select id,name,toString(Info_list) as infolist from tb2 ) temp"

    val readDataDf = session.read
      .format("jdbc")
      .option("url", "jdbc:clickhouse://127.0.0.1:8123/xqtestdb")
      .option("fetchsize", "500000")
      .option("driver", "ru.yandex.clickhouse.ClickHouseDriver")
//      .option("user", "default")
//      .option("password", "123456")
      .option("dbtable", tablename)
      .load()
    readDataDf.show()



//        sqlDF1
//      .write
//      .mode(SaveMode.Append)
//      .option("batchsize", "500000")
//      .option("isolationLevel", "NONE")
//      .option("numPartitions", "1")
//      .jdbc("jdbc:clickhouse://127.0.0.1:8123/xqtestdb",
//        "tb2", prop)





    // close
    session.close()

  }

}
