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
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.acme;

import javax.ejb.MessageDriven;
import javax.jms.Acknowledge;
import javax.jms.ClientId;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSListener;
import javax.jms.JMSMessageDrivenBean;
import javax.jms.Message;
import javax.jms.MessageSelector;
import javax.jms.SubscriptionDurability;
import javax.jms.SubscriptionName;
import javax.jms.TextMessage;
import java.util.Map;

@MessageDriven
public class MessageCoercion implements JMSMessageDrivenBean {

    /**
     * A parameter may be Message or one of its five subtypes TextMessage,
     * StreamMessage, BytesMessage, MapMessage, ObjectMessage. This avoids
     * the need for the listener method to cast the Message to the expected subtype.
     */
    @JMSListener(lookup = "java:global/java:global/Trades", type = JMSListener.Type.TOPIC)
    void processTrade(TextMessage textMessage) {
        //...
    }

    /**
     * If the message is a TextMessage then any parameter of type String
     * (and which is not annotated with @MessageHeader or @MessageProperty)
     * will be set to contain the message body.
     */
    @JMSListener(lookup = "java:global/java:global/Trades", type = JMSListener.Type.TOPIC)
    void processTrade(String messageText) {
    }

    /**
     * If the message is a ObjectMessage then any parameter to which
     * the message body is assignable (and which is not annotated with
     * @MessageHeader or @MessageProperty) will be set to contain the message body.
     *
     */
    @JMSListener(lookup = "java:global/java:global/Trades", type = JMSListener.Type.TOPIC)
    void processTrade(Trade incomingTrade) {
    }


    /**
     * If the message is a MapMessage then any parameter of type Map (and
     * which is not annotated with @MessageHeader or @MessageProperty) will
     * be set to contain the message body.
     */
    @JMSListener(lookup = "java:global/java:global/Trades", type = JMSListener.Type.TOPIC)
    void processTrade(Map tradeData) {
    }

    /**
     * If the message is a BytesMessage then any parameter of type byte[]
     * (and which is not annotated with @MessageHeader or @MessageProperty)
     * will be set to contain the message body.
     */
    @JMSListener(lookup = "java:global/java:global/Trades", type = JMSListener.Type.TOPIC)
    void processTrade(byte[] tradeBytes) {
    }
}
