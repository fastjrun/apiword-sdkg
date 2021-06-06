package com.fastjrun.apiworld.dto;

import com.fastjrun.utils.JacksonUtils;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ResultListModel<T> implements Serializable {

  private static final long serialVersionUID = 828655026342216609L;
  private String code;
  private String msg = "";
  private List<T> data;

  public ResultListModel(String code) {
    this.code = code;
  }

  public ResultListModel(String code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public ResultListModel(String code, String msg, List<T> data) {
    this.code = code;
    this.msg = msg;
    this.data = data;
  }

  @Override
  public String toString() {
    return JacksonUtils.toJSon(this);
  }
}
