package com.fastjrun.apiworld.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ResultListModel<T> extends BaseResultModel implements Serializable {

  private static final long serialVersionUID = -4710875926501827304L;

  private List<T> data;

  public ResultListModel() {
    super();
  }

  public ResultListModel(String code) {
    super(code);
  }

  public ResultListModel(String code, String msg) {
    super(code, msg);
  }

  public ResultListModel(String code, String msg, List<T> data) {
    this(code, msg);
    this.data = data;
  }
}
