package com.xq.sql_example

import org.apache.spark.SparkConf
import org.apache.spark.sql._

/**
  * @desc xxx
  * @author zhangxiaoqiong
  * @date 2021/7/13 15:13
  */
object Hive03 {

  def main(args: Array[String]): Unit = {
    System.setProperty("HADOOP_USER_NAME", "root")

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")
    val spark = SparkSession.builder().enableHiveSupport().config(sparkConf).getOrCreate()

    spark.sql("use zxqdw")

    // 查询基本数据
    spark.sql(
      """
        |  select
        |     a.*,
        |     p.product_name,
        |     c.area,
        |     c.city_name
        |  from user_visit_action a
        |  join product_info p on a.click_product_id = p.product_id
        |  join city_info c on a.city_id = c.city_id
        |  where a.click_product_id > -1
      """.stripMargin).createOrReplaceTempView("t1")


    spark.sql(
      """
        |  select
        |     area,
        |     product_name,
        |     count(*) as clickCnt
        |  from t1 group by area, product_name
      """.stripMargin).createOrReplaceTempView("t2")

    // 区域内对点击数量进行排行
    spark.sql(
      """
        |  select
        |      *,
        |      rank() over( partition by area order by clickCnt desc ) as rank
        |  from t2
      """.stripMargin).createOrReplaceTempView("t3")

    // 取前3名
    spark.sql(
      """
        | select
        |     *
        | from t3 where rank <= 3
      """.stripMargin).show(false)

    spark.close()
  }



}
