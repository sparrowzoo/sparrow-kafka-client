/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sparrow.kafka;

import com.sparrow.mq.MQEvent;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.rocketmq.common.message.Message;

import java.io.UnsupportedEncodingException;

/**
 * Created by harry on 2017/6/14.
 */
public interface MessageConverter<K> {
    /**
     * 生成mq event
     *
     * @param message
     * @return
     */
    MQEvent fromMessage(ConsumerRecord<K,String> message) throws UnsupportedEncodingException;

    /**
     * 获取rocket mq messages
     *
     * @param topic
     * @param k
     * @param event
     * @return
     */
    ProducerRecord<K,String> createMessage(String topic, K k, MQEvent event);
}
