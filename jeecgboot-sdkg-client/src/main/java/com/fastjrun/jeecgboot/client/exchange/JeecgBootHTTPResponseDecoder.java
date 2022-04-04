/*
 * Copyright (C) 2019 fastjrun, Inc. All Rights Reserved.
 */
package com.fastjrun.jeecgboot.client.exchange;

import com.fasterxml.jackson.databind.JsonNode;
import com.fastjrun.jeecgboot.client.common.JeecgBootCodeMsgConstants;
import com.fastjrun.jeecgboot.client.common.ClientException;
import com.fastjrun.client.exchange.BaseHTTPResponseDecoder;

import java.io.IOException;

public class JeecgBootHTTPResponseDecoder extends BaseHTTPResponseDecoder {

    @Override
    protected JsonNode parseBodyFromResponse(String responseResult) {
        JsonNode responseJsonObject;
        try {
            responseJsonObject = this.objectMapper.readTree(responseResult);
        } catch (IOException e) {
            throw new ClientException(JeecgBootCodeMsgConstants.SWCodeEnum.ClIENT_RESPONSE_NOT_VALID);
        }

        JsonNode codeNode = responseJsonObject.get("code");

        if (codeNode == null) {
            throw new ClientException(JeecgBootCodeMsgConstants.SWCodeEnum.CLIENT_RESPONSE_CODE_NULL);
        }
        Integer code = codeNode.asInt();
        if (code == 0) {
            throw new ClientException(JeecgBootCodeMsgConstants.SWCodeEnum.ClIENT_RESPONSE_CODE_VALID);
        }
        if (code == JeecgBootCodeMsgConstants.SWCodeEnum.CODE_OK.intValue()) {
            return responseJsonObject.get("data");
        }
        JsonNode msgNode = responseJsonObject.get("message");
        if (msgNode == null) {
            throw new ClientException(JeecgBootCodeMsgConstants.SWCodeEnum.ClIENT_RESPONSE_MESSAGE_NULL);
        }
        String msg = msgNode.asText();
        if (msg.equals("")) {
            throw new ClientException(JeecgBootCodeMsgConstants.SWCodeEnum.ClIENT_RESPONSE_CODE_VALID);
        }
        log.warn("code = {},message = {}", code, msg);

        throw new ClientException(code, msg);
    }
}
