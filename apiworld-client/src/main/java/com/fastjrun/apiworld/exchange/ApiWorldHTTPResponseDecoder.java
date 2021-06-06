/*
 * Copyright (C) 2019 fastjrun, Inc. All Rights Reserved.
 */
package com.fastjrun.apiworld.exchange;


import com.fasterxml.jackson.databind.JsonNode;
import com.fastjrun.apiworld.common.ApiWorldCodeMsgConstants;
import com.fastjrun.common.ClientException;
import com.fastjrun.common.exchange.BaseHTTPResponseDecoder;

import java.io.IOException;

public class ApiWorldHTTPResponseDecoder extends BaseHTTPResponseDecoder {

    @Override
    protected JsonNode parseBodyFromResponse(String responseResult) {
        JsonNode responseJsonObject;
        try {
            responseJsonObject = this.objectMapper.readTree(responseResult);
        } catch (IOException e) {
            throw new ClientException(ApiWorldCodeMsgConstants.SWCodeEnum.ClIENT_RESPONSE_NOT_VALID);
        }

        JsonNode codeNode = responseJsonObject.get("code");

        if (codeNode == null) {
            throw new ClientException(ApiWorldCodeMsgConstants.SWCodeEnum.CLIENT_RESPONSE_CODE_NULL);
        }
        String code = codeNode.asText();
        if (code.equals("")) {
            throw new ClientException(ApiWorldCodeMsgConstants.SWCodeEnum.CLIENT_RESPONSE_CODE_EMPTY);
        }
        if (code.equals(ApiWorldCodeMsgConstants.CODE_OK)) {
            return responseJsonObject.get("data");
        }
        JsonNode msgNode = responseJsonObject.get("msg");
        if (msgNode == null) {
            throw new ClientException(ApiWorldCodeMsgConstants.SWCodeEnum.ClIENT_RESPONSE_MSG_NULL);
        }
        String msg = msgNode.asText();
        if (msg.equals("")) {
            throw new ClientException(ApiWorldCodeMsgConstants.SWCodeEnum.ClIENT_RESPONSE_MSG_EMPTY);
        }
        log.warn("code = {},msg = {}", code, msg);

        throw new ClientException(code, msg);
    }
}
