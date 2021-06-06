/*
 * Copyright (C) 2019 fastjrun, Inc. All Rights Reserved.
 */
package com.fastjrun.apiworld.sdkg.generator.processor;

import com.fastjrun.codeg.processer.BaseResponseProcessor;
import com.helger.jcodemodel.JBlock;
import com.helger.jcodemodel.JCodeModel;
import com.helger.jcodemodel.JExpr;
import com.helger.jcodemodel.JInvocation;

public class ApiWorldResponseProcessor extends BaseResponseProcessor {

  static String DEFAULT_RESPONSE_CLASS_NAME = "com.fastjrun.apiworld.dto.ResultDataModel";

  static String DEFAULT_LISTRESPONSE_CLASS_NAME = "com.fastjrun.apiworld.dto.ResultListDataModel";

  static String DEFAULT_RESPONSE_HELPER_CLASS_NAME = "com.fastjrun.apiworld.helper.ResultHelper";

  @Override
  public void processResponse(JBlock methodBlk, JInvocation jInvocation, JCodeModel cm) {
    String responseHelperMethodName = "ok";
    if (this.isResponseIsArray()) {
      responseHelperMethodName = "okList";
    }
    methodBlk.decl(
        this.responseClass,
        "result",
        cm.ref(DEFAULT_RESPONSE_HELPER_CLASS_NAME).staticInvoke(responseHelperMethodName));
    if (this.elementClass == null) {
      methodBlk.add(jInvocation);
    } else {
      if (this.isResponseIsArray()) {
        methodBlk.decl(
            cm.ref("java.util.List").narrow(this.elementClass), "resultData", jInvocation);
      } else {
        methodBlk.decl(this.elementClass, "resultData", jInvocation);
      }
      methodBlk.add(JExpr.ref("result").invoke("setData").arg(JExpr.ref("resultData")));
    }
    methodBlk.add(
        JExpr.ref("log")
            .invoke("debug")
            .arg(JExpr.lit("result={}"))
            .arg(JExpr.ref("result")));
    methodBlk._return(JExpr.ref("result"));
  }

  @Override
  public void parseResponseClass(JCodeModel cm) {
    if (this.elementClass != null) {
      if (!this.isResponseIsArray()) {
        this.responseClass = cm.ref(DEFAULT_RESPONSE_CLASS_NAME).narrow(this.elementClass);
      } else {
        this.responseClass = cm.ref(DEFAULT_LISTRESPONSE_CLASS_NAME).narrow(this.elementClass);
      }
    } else {
      if (!this.isResponseIsArray()) {
        this.responseClass = cm.ref(DEFAULT_RESPONSE_CLASS_NAME);
      } else {
        this.responseClass = cm.ref(DEFAULT_LISTRESPONSE_CLASS_NAME);
      }
    }
  }
}
