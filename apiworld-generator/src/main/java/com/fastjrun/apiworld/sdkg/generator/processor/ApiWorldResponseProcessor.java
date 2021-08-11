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

  static String DEFAULT_RESPONSE_CLASS_NAME = "com.fastjrun.apiworld.dto.ResultModel";

  static String DEFAULT_LISTRESPONSE_CLASS_NAME = "com.fastjrun.apiworld.dto.ResultListModel";

  static String DEFAULT_PAGERESPONSE_CLASS_NAME = "com.fastjrun.apiworld.dto.ResultPageModel";

  static String DEFAULT_RESPONSE_HELPER_CLASS_NAME = "com.fastjrun.apiworld.helper.ResultHelper";

  @Override
  public void processResponse(JBlock methodBlk, JInvocation jInvocation, JCodeModel cm) {
    String responseHelperMethodName = "ok";
    if (this.isResponseIsPage()) {
      responseHelperMethodName = "okPage";
    } else if (this.isResponseIsList()) {
      responseHelperMethodName = "okList";
    }
    methodBlk.decl(
        this.responseClass,
        "result",
        cm.ref(DEFAULT_RESPONSE_HELPER_CLASS_NAME).staticInvoke(responseHelperMethodName));
    if (this.elementClass == null) {
      methodBlk.add(jInvocation);
    } else {
      if (this.isResponseIsPage()) {
        methodBlk.decl(
            cm.ref("com.fastjrun.dto.PageResult").narrow(this.elementClass),
            "resultData",
            jInvocation);
      } else if (this.isResponseIsList()) {
        methodBlk.decl(
            cm.ref("java.util.List").narrow(this.elementClass), "resultData", jInvocation);
      } else {
        methodBlk.decl(this.elementClass, "resultData", jInvocation);
      }
      methodBlk.add(JExpr.ref("result").invoke("setData").arg(JExpr.ref("resultData")));
    }
    methodBlk.add(
        JExpr.ref("log").invoke("debug").arg(JExpr.lit("result={}")).arg(JExpr.ref("result")));
    methodBlk._return(JExpr.ref("result"));
  }

  @Override
  public void parseResponseClass(JCodeModel cm) {
    if (this.elementClass != null) {
      if (this.isResponseIsPage()) {
        this.responseClass = cm.ref(DEFAULT_PAGERESPONSE_CLASS_NAME).narrow(this.elementClass);
      } else if (this.isResponseIsList()) {
        this.responseClass = cm.ref(DEFAULT_LISTRESPONSE_CLASS_NAME).narrow(this.elementClass);
      } else {
        this.responseClass = cm.ref(DEFAULT_RESPONSE_CLASS_NAME).narrow(this.elementClass);
      }
    } else {
      if (this.isResponseIsPage()) {
        this.responseClass = cm.ref(DEFAULT_PAGERESPONSE_CLASS_NAME);
      } else if (this.isResponseIsList()) {
        this.responseClass = cm.ref(DEFAULT_LISTRESPONSE_CLASS_NAME);
      } else {
        this.responseClass = cm.ref(DEFAULT_RESPONSE_CLASS_NAME);
      }
    }
  }
}
