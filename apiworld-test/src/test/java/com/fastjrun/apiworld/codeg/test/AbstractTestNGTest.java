/*
 * Copyright (C) 2019 fastjrun, Inc. All Rights Reserved.
 */
package com.fastjrun.apiworld.codeg.test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fastjrun.codeg.common.CodeGException;
import com.fastjrun.test.AbstractAdVancedTestNGSpringContextTest;
import org.testng.Assert;

public abstract class AbstractTestNGTest extends AbstractAdVancedTestNGSpringContextTest {

    protected <T> void processExceptionInResponse(JsonNode assertJson, Exception e) {
        if (e instanceof CodeGException && assertJson != null) {
            JsonNode codeJson = assertJson.get("code");
            if (codeJson != null) {
                String code = codeJson.asText();
                if (code != null) {
                    Assert.assertEquals(((CodeGException) e).getCode(), code, "消息码不同");
                }
            } else {
                log.error("", e);
            }
        } else {
            log.error("", e);
        }
    }

}
