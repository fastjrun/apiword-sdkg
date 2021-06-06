package com.fastjrun.apiworld.dto;

import com.fastjrun.utils.JacksonUtils;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
public class ResultModel<T> implements Serializable {

  private static final long serialVersionUID = 828655026342216609L;
  private String code;
  private String msg = "";
  private T data;

  public ResultModel(String code) {
    this.code = code;
  }

  public ResultModel(String code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public ResultModel(String code, String msg, T data) {
    this.code = code;
    this.msg = msg;
    this.data = data;
  }

  @Override
  public String toString() {
    return JacksonUtils.toJSon(this);
  }
}
