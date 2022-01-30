/*
 * Copyright (C) 2019 fastjrun, Inc. All Rights Reserved.
 */
package com.fastjrun.apiworld.common;

public interface CodeMsgI {

    Integer CODE_OK = 2000;

    String CODE_OK_MSG = "OK";

    Integer getCode();

    String getMsg();
}
