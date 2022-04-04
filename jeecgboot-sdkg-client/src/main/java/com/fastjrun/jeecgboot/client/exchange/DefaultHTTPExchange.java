/*
 * Copyright (C) 2019 fastjrun, Inc. All Rights Reserved.
 */
package com.fastjrun.jeecgboot.client.exchange;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fastjrun.client.exchange.BaseHTTPExchange;
import com.fastjrun.common.util.FastJsonObjectMapper;

public class DefaultHTTPExchange extends BaseHTTPExchange<DefaultHTTPRequestEncoder, JeecgBootHTTPResponseDecoder> {

    public DefaultHTTPExchange() {
        ObjectMapper objectMapper = new FastJsonObjectMapper();
        this.requestEncoder = new DefaultHTTPRequestEncoder();
        this.requestEncoder.setObjectMapper(objectMapper);
        this.responseDecoder = new JeecgBootHTTPResponseDecoder();
        this.responseDecoder.setObjectMapper(objectMapper);
    }
}
