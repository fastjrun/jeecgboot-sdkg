/*
 * Copyright (C) 2019 fastjrun, Inc. All Rights Reserved.
 */
package com.fastjrun.jeecgboot.client.exchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fastjrun.jeecgboot.client.common.ClientException;
import com.fastjrun.jeecgboot.client.common.JeecgBootCodeMsgConstants;
import com.fastjrun.client.exchange.BaseHTTPRequestEncoder;


public class DefaultHTTPRequestEncoder extends BaseHTTPRequestEncoder {

    @Override
    public String generateRequestBody(Object body) {
        String bodyData;
        try {
            bodyData = this.objectMapper.writeValueAsString(body);
        } catch (JsonProcessingException e) {
            throw new ClientException(JeecgBootCodeMsgConstants.SWCodeEnum.ClIENT_REQUEST_COMPOSE_FAIL);
        }
        return bodyData;
    }
}
