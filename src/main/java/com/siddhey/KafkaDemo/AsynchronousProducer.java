/**
 * Copyright (C) 2016-2018 KyePot - All Rights Reserved Unauthorized copying of this file, via any medium
 * is strictly prohibited Proprietary and confidential.
 */
/**
 * 
 */
package com.siddhey.KafkaDemo;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

/**
 * @author siddhey
 *
 */
public class AsynchronousProducer {
  
public static void main(String[] args) throws Exception{
    
    String topicName = "SiddheyTopic";
    String key = "key1";
    String value = "message from aliens";
    
    Properties properties = new Properties();
    properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    
    Producer<String, String> producer = new KafkaProducer<>(properties);
    
    ProducerRecord<String, String> record = new ProducerRecord<>(topicName,key,value);
    
    producer.send(record, new MyProducerCallback());
    System.out.println("AsynchronousProducer call completed");
    producer.close();
    
  }

}

class MyProducerCallback implements Callback {

  @Override
  public void onCompletion(RecordMetadata recordMetadata, Exception e) {
    if (e != null)
      System.out.println("AsynchronousProducer failed with an exception");
    else
      System.out.println("AsynchronousProducer call Success:");
  }
}
