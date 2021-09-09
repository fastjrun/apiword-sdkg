package com.fastjrun.apiworld.vo;

import lombok.Data;

@Data
public abstract class BaseResultModel {
  protected Integer code;

  protected String message = "";
}
