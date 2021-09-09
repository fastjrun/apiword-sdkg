package com.fastjrun.apiworld.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ResultModel<T> extends BaseResultModel implements Serializable {

  private static final long serialVersionUID = 828655026342216609L;
  private T data;

  public ResultModel(Integer code, String message) {
    this(code,message,null);
  }

  public ResultModel(Integer code, String message, T result) {
    this.code = code;
    this.message = message;
    this.data = result;
  }
}
