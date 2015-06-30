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
import javax.jms.Destination;
import javax.jms.Header;
import javax.jms.JMSMessageDrivenBean;
import javax.jms.MessageHeader;

@MessageDriven
public class MessageHeaders implements JMSMessageDrivenBean {

    void example1(@MessageHeader(Header.JMSMessageID) String var1) {
    }

    void example2(@MessageHeader(Header.JMSTimestamp) long var1) {
    }

    void example2(@MessageHeader(Header.JMSTimestamp) Long var1) {
    }

    void example3(@MessageHeader(Header.JMSCorrelationIDAsBytes) byte[] var1) {
    }

    void example4(@MessageHeader(Header.JMSCorrelationID) String var1) {
    }

    void example5(@MessageHeader(Header.JMSReplyTo) Destination var1) {
    }

    void example6(@MessageHeader(Header.JMSDestination) Destination var1) {
    }

    void example7(@MessageHeader(Header.JMSDeliveryMode) int var1) {
    }

    void example7(@MessageHeader(Header.JMSDeliveryMode) Integer var1) {
    }

    void example8(@MessageHeader(Header.JMSRedelivered) boolean var1) {
    }

    void example8(@MessageHeader(Header.JMSRedelivered) Boolean var1) {
    }

    void example9(@MessageHeader(Header.JMSType) String var1) {
    }

    void example10(@MessageHeader(Header.JMSExpiration) long var1) {
    }

    void example10(@MessageHeader(Header.JMSExpiration) Long var1) {
    }

    void example11(@MessageHeader(Header.JMSPriority) int var1) {
    }

    void example11(@MessageHeader(Header.JMSPriority) Integer var1) {
    }

}
