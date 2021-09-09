package com.fastjrun.apiworld.common;

import lombok.Data;

@Data
public class ClientException extends RuntimeException {

  protected Integer code;

  protected String msg;

  private static final long serialVersionUID = 881662792715958086L;

  public ClientException(Integer code, String msg) {
    super(msg);
    this.code = code;
    this.msg = msg;
  }

  public ClientException(ApiWorldCodeMsgConstants.SWCodeEnum codeMsg) {
    this(codeMsg.getCode(), codeMsg.getMsg());
  }
}
