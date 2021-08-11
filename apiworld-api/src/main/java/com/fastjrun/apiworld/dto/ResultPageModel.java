package com.fastjrun.apiworld.dto;

import com.fastjrun.dto.PageResult;
import lombok.Data;

import java.io.Serializable;

@Data
public class ResultPageModel<T> extends BaseResultModel implements Serializable {

  private static final long serialVersionUID = -4710875926501827304L;

  private PageResult<T> data;

  public ResultPageModel() {
    super();
  }

  public ResultPageModel(String code) {
    super(code);
  }

  public ResultPageModel(String code, String msg) {
    super(code, msg);
  }

  public ResultPageModel(String code, String msg, PageResult<T> data) {
    this(code, msg);
    this.data = data;
  }
}
