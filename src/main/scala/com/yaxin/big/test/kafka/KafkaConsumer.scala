package com.yaxin.big.test.kafka

import kafka.javaapi.consumer.ConsumerConnector
import kafka.consumer.ConsumerConfig
import scala.io.Source
import java.util.Properties
import java.io.FileInputStream
import kafka.consumer.Consumer
import java.util.HashMap
import scala.collection.JavaConversions._
import kafka.consumer.KafkaStream

object KafkaConsumer {
  
  def main(args  : Array[String]){
    val prop = new Properties
    val path = Thread.currentThread.getContextClassLoader.getResource("kafka.properties").getPath
    prop.load(new FileInputStream(path))
    val conf = new ConsumerConfig(prop)
    val connector = Consumer.createJavaConsumerConnector(conf)
    val map = new HashMap[String,Integer]
    map.put("channel142", 1)
    val streams = connector.createMessageStreams(map) 
    val list = streams.get("channel142");
    list.foreach{
      stream => createThread(stream)
    }
  }
  
  def createThread(stream : KafkaStream[Array[Byte], Array[Byte]]){
    val thread = new Thread{
      override def run{
        val it = stream.iterator()
        while(it.hasNext){
          val data = it.next;
          println(new String(data.message))
        }
      }
    }
    thread.start
  }
}