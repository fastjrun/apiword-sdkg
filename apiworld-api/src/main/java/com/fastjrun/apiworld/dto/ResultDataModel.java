package com.fastjrun.apiworld.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultDataModel<T> extends BaseResultModel implements Serializable {

  private static final long serialVersionUID = 828655026342216609L;
  private T data;

  public ResultDataModel() {
    super();
  }

  public ResultDataModel(String code) {
    super(code);
  }

  public ResultDataModel(String code, String msg) {
    super(code,msg);
  }

  public ResultDataModel(String code, String msg, T data) {
    this(code, msg);
    this.data = data;
  }

}
