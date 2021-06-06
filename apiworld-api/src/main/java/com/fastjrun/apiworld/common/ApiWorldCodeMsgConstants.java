package com.fastjrun.apiworld.common;

import com.fastjrun.common.CodeMsgI;

public interface ApiWorldCodeMsgConstants {

  String CODE_OK = "0000";

  public enum SWCodeEnum implements CodeMsgI {
    OK(CODE_OK, "OK"),
    CODE_UNKNOWN("9999", "UNKNOWN"),
    ClIENT_NETWORK_NOT_AVAILABLE("9998", "网络异常"),
    ClIENT_SERVER_EXCEPTION("9998", "服务端系统异常"),
    ClIENT_RESPONSE_EMPTY("9998", "返回数据为空"),
    ClIENT_REQUEST_COMPOSE_FAIL("9998", "组装报文失败"),
    ClIENT_RESPONSE_NOT_VALID("9998", "返回数据不是json格式"),
    CLIENT_RESPONSE_CODE_NULL("6994", "返回数据code为空"),
    CLIENT_RESPONSE_CODE_EMPTY("9998", "返回数据head中code为空值"),
    ClIENT_RESPONSE_DATA_NOT_VALID("9998", "返回数据中body不是约定的报文格式"),
    ClIENT_RESPONSE_MSG_NULL("9998", "返回数据中没有msg"),
    ClIENT_REQUEST_QUERYSTRING_ENCODE_FAIL("9998", "url编码错误，不支持utf8"),
    ClIENT_NETWORK_RESPONSE_NOT_OK("9998", "返回响应不成功"),
    ClIENT_RESPONSE_MSG_EMPTY("9998", "返回数据中msg节点为空");
    private String code;

    private String msg;

    SWCodeEnum(String code, String msg) {
      this.code = code;
      this.msg = msg;
    }

    @Override
    public String getCode() {
      return code;
    }

    @Override
    public String getMsg() {
      return msg;
    }
  }
}
