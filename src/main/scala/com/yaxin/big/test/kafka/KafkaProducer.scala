package com.yaxin.big.test.kafka

import java.util.Properties
import scala.collection.JavaConversions._
import java.io.FileInputStream
import kafka.producer.ProducerConfig
import kafka.producer.Producer
import kafka.producer.KeyedMessage

object KafkaProducer {
  
  def main(args : Array[String]){
    val prop = new Properties
    val path = Thread.currentThread().getContextClassLoader.getResource("kafka.properties").getPath
    prop.load(new FileInputStream(path))
    val conf = new ProducerConfig(prop)
    val producer = new Producer[Integer,String](conf)
    val msg = new KeyedMessage[Integer,String]("channel142","ssss")
    producer.send(msg)
  }
}