package com.fastjrun.apiworld.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ResultDataListModel<T> extends BaseResultModel implements Serializable {

  private static final long serialVersionUID = -4710875926501827304L;

  private List<T> data;

  public ResultDataListModel() {
    super();
  }

  public ResultDataListModel(String code) {
    super(code);
  }

  public ResultDataListModel(String code, String msg) {
    super(code, msg);
  }

  public ResultDataListModel(String code, String msg, List<T> data) {
    this(code, msg);
    this.data = data;
  }
}
