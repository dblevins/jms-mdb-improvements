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
public class PerfectBean implements JMSMessageDrivenBean {

    @JMSConnectionFactory("java:global/MyCF")
    @JMSListener(lookup = "java:global/java:global/Trades", type = JMSListener.Type.TOPIC)
    @SubscriptionDurability(SubscriptionDurability.Mode.DURABLE)
    @ClientId("myClientID1")
    @SubscriptionName("mySubName1")
    @MessageSelector("ticker=ORCL'")
    @Acknowledge(Acknowledge.Mode.DUPS_OK_ACKNOWLEDGE)
    public void giveMeAMessage(Message message) {
        //
    }

    @JMSListener(lookup = "java:global/Trades", type = JMSListener.Type.TOPIC)
    public void letMeHaveIt(Message message) {

    }


    @SubscriptionDurability(SubscriptionDurability.Mode.DURABLE)
    @SubscriptionName("mySubName1")
    @ClientId("myClientID1")
    @JMSListener(lookup = "java:global/inboundTopic", type = JMSListener.Type.TOPIC)
    public void consumeMyTopic(Message message) {
        //
    }


    @MessageSelector("JMSType = 'car' AND colour = 'blue'")
    @JMSListener(lookup = "java:global/requestQueue", type = JMSListener.Type.QUEUE)
    public void iGotThis(Message message) {
        // ...
    }


    /**
     * A parameter may be Message or one of its five subtypes TextMessage,
     * StreamMessage, BytesMessage, MapMessage, ObjectMessage. This avoids
     * the need for the listener method to cast the Message to the expected subtype.
     */
    void processTrade(TextMessage textMessage) {
        //...
    }

    /**
     * If the message is a TextMessage then any parameter of type String
     * (and which is not annotated with @MessageHeader or @MessageProperty)
     * will be set to contain the message body.
     */
    void processTrade(String messageText) {
    }

    /**
     * If the message is a ObjectMessage then any parameter to which
     * the message body is assignable (and which is not annotated with
     * @MessageHeader or @MessageProperty) will be set to contain the message body.
     *
     */
    void processTrade(Trade incomingTrade) {
    }


    /**
     * If the message is a MapMessage then any parameter of type Map (and
     * which is not annotated with @MessageHeader or @MessageProperty) will
     * be set to contain the message body.
     */
    void processTrade(Map tradeData) {
    }

    /**
     * If the message is a BytesMessage then any parameter of type byte[]
     * (and which is not annotated with @MessageHeader or @MessageProperty)
     * will be set to contain the message body.
     */
    void processTrade(byte[] tradeBytes) {
    }
}
