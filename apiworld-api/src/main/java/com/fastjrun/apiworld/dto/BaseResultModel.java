package com.fastjrun.apiworld.dto;

import com.fastjrun.utils.JacksonUtils;
import lombok.Data;

@Data
public abstract class BaseResultModel {
  private String code;
  private String msg = "";

  public BaseResultModel() {}

  public BaseResultModel(String code) {
    this.code = code;
  }

  public BaseResultModel(String code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  @Override
  public String toString() {
    return JacksonUtils.toJSon(this);
  }
}
