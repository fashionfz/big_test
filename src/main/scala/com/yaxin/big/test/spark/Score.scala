package com.yaxin.big.test.spark

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

import play.api.libs.json._
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.clustering.KMeans

object Score {
  
  def main(args : Array[String]) : Unit = {
    val conf = new SparkConf().setAppName("score")
    val sc = new SparkContext();
    val line = sc.textFile("hdfs://master142:9000/itba/UDP_174/2016-08-18/data.txt")
    val parsed = line.map(Json.parse)

    case class Info(name: String, website: String) { 
      override def toString: String = name + "\t" + website 
    } 
    //val result = parsed.map(x => (x.\("name").get+","+(x \ "").get,(x \ "value").toString().toDouble)) */
    val map =line.map(x=>Vectors.dense(x.split(" ").map(_.toDouble)))
    val xx = Json.parse("{\"name\":\"abc\"}")
    
    val yy = xx.\("name").get.toString.replaceAll("\"","")
    
    println(yy)
    
    val clu = KMeans.train(map,1,1);
    
    val json = line.map(Json.parse)
    
    val vec = json.filter(x=>(x.\("instanceName").get.toString.replaceAll("\"","").equals("WIN2003-MQ") && x.\("metricId").get.toString.replaceAll("\"","").equals("memRate"))).map(x=>(1,x.\("metricValue").get.toString.replaceAll("\"","").toDouble))
    clu.clusterCenters.foreach(println)
    
    
  }
}