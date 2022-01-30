/*
 * Copyright (C) 2019 fastjrun, Inc. All Rights Reserved.
 */
package com.fastjrun.apiworld.codeg.generator.processor;

import com.fastjrun.codeg.processor.BaseRequestProcessor;
import com.helger.jcodemodel.JCodeModel;
import com.helger.jcodemodel.JInvocation;
import com.helger.jcodemodel.JMethod;

public class ApiWorldRequestProcessor extends BaseRequestProcessor {

    @Override
    public String processHTTPRequest(JMethod method, JInvocation jInvocation, MockModel mockModel,
      JCodeModel cm) {
        return "";
    }

    @Override
    public void parseRequestClass(JCodeModel cm) {
        this.requestClass = this.requestBodyClass;
    }
}
