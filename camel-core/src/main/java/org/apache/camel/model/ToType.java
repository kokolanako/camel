/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.model;

import org.apache.camel.Processor;
import org.apache.camel.impl.RouteContext;
import org.apache.camel.processor.SendProcessor;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collections;
import java.util.List;

/**
 * Represents an XML &lt;to/&gt; element
 *
 * @version $Revision: $
 */
@XmlRootElement(name = "to")
public class ToType extends ProcessorType {
    private String uri;
    private List<InterceptorRef> interceptors;

    @Override
    public String toString() {
        return "To[" + uri + "]";
    }

    @Override
    public Processor createProcessor(RouteContext routeContext) {
        return new SendProcessor(routeContext.resolveEndpoint(getUri()));
    }

    // Properties
    //-----------------------------------------------------------------------
    @XmlAttribute
    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public List<ProcessorType> getOutputs() {
        return Collections.EMPTY_LIST;
    }

    @XmlElement(required = false)
    public List<InterceptorRef> getInterceptors() {
        return interceptors;
    }

    public void setInterceptors(List<InterceptorRef> interceptors) {
        this.interceptors = interceptors;
    }
}