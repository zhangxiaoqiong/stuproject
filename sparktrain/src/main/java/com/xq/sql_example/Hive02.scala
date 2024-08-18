package com.xq.sql_example

import org.apache.spark.SparkConf
import org.apache.spark.sql._

object Hive02 {

    def main(args: Array[String]): Unit = {
        System.setProperty("HADOOP_USER_NAME", "root")

        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")
        val spark = SparkSession.builder().enableHiveSupport().config(sparkConf).getOrCreate()

        spark.sql("use zxqdw")

        // 准备数据
        spark.sql(
            """
              |CREATE TABLE if not exists `user_visit_action`(
              |  `date` string,
              |  `user_id` bigint,
              |  `session_id` string,
              |  `page_id` bigint,
              |  `action_time` string,
              |  `search_keyword` string,
              |  `click_category_id` bigint,
              |  `click_product_id` bigint,
              |  `order_category_ids` string,
              |  `order_product_ids` string,
              |  `pay_category_ids` string,
              |  `pay_product_ids` string,
              |  `city_id` bigint)
              |row format delimited fields terminated by '_'
            """.stripMargin)

        spark.sql(
            """
              |load data local inpath 'data/user_visit_action.txt' into table user_visit_action
            """.stripMargin)

        spark.sql(
            """
              |CREATE TABLE if not exists `product_info`(
              |  `product_id` bigint,
              |  `product_name` string,
              |  `extend_info` string)
              |row format delimited fields terminated by '\t'
            """.stripMargin)

        spark.sql(
            """
              |load data local inpath 'data/product_info.txt' into table product_info
            """.stripMargin)

        spark.sql(
            """
              |CREATE TABLE if not exists `city_info`(
              |  `city_id` bigint,
              |  `city_name` string,
              |  `area` string)
              |row format delimited fields terminated by '\t'
            """.stripMargin)

        spark.sql(
            """
              |load data local inpath 'data/city_info.txt' into table city_info
            """.stripMargin)

        spark.sql("""select * from user_visit_action limit 10""").show
        spark.sql("""select * from product_info limit 10""").show
        spark.sql("""select * from city_info""").show

        spark.close()
    }
}
