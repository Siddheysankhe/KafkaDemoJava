/**
 * Copyright (C) 2016-2018 KyePot - All Rights Reserved Unauthorized copying of this file, via any medium
 * is strictly prohibited Proprietary and confidential.
 */
/**
 * 
 */
package com.siddhey.KafkaDemo;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

/**
 * @author siddhey
 *
 */
public class SimpleProducer {
  
  public static void main(String[] args){
    
    String topicName = "SiddheyTopic";
    String key = "key1";
    String value = "xyx";
    
    Properties properties = new Properties();
    properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    
    Producer<String, String> producer = new KafkaProducer<>(properties);
    
    ProducerRecord<String, String> record = new ProducerRecord<>(topicName,key,value);
    producer.send(record);
    producer.close();
    
    System.out.println("SimpleProducer Completed.");
    
  }

}
