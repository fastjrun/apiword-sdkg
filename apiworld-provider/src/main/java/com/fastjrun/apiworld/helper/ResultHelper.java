package com.fastjrun.apiworld.helper;

import com.fastjrun.apiworld.common.ApiWorldCodeMsgConstants;
import com.fastjrun.apiworld.dto.ResultDataListModel;
import com.fastjrun.apiworld.dto.ResultDataModel;

import java.util.List;

public class ResultHelper {

  public static <T> ResultDataModel<T> ok() {
    return result(ApiWorldCodeMsgConstants.SWCodeEnum.OK);
  }

  public static <T> ResultDataModel<T> ok(T result) {
    return result(ApiWorldCodeMsgConstants.SWCodeEnum.OK, result);
  }

  public static <T> ResultDataModel<T> fail(ApiWorldCodeMsgConstants.SWCodeEnum code) {
    return result(code);
  }

  public static <T> ResultDataModel<T> result(ApiWorldCodeMsgConstants.SWCodeEnum code) {
    return result(code, null);
  }

  public static <T> ResultDataModel<T> result(ApiWorldCodeMsgConstants.SWCodeEnum code, T result) {
    return new ResultDataModel(code.getCode(), code.getMsg(), result);
  }

  public static <T> ResultDataModel<T> fail(String code, String msg) {
    return new ResultDataModel(code, msg);
  }

  public static <T> ResultDataListModel<T> okList() {
    return resultList(ApiWorldCodeMsgConstants.SWCodeEnum.OK);
  }

  public static <T> ResultDataListModel<T> okList(List<T> result) {
    return resultList(ApiWorldCodeMsgConstants.SWCodeEnum.OK, result);
  }

  public static <T> ResultDataListModel<T> failList(ApiWorldCodeMsgConstants.SWCodeEnum code) {
    return resultList(code);
  }

  public static <T> ResultDataListModel<T> resultList(ApiWorldCodeMsgConstants.SWCodeEnum code) {
    return resultList(code, null);
  }

  public static <T> ResultDataListModel<T> resultList(
      ApiWorldCodeMsgConstants.SWCodeEnum code, List<T> result) {
    return new ResultDataListModel(code.getCode(), code.getMsg(), result);
  }

  public static <T> ResultDataListModel<T> failList(String code, String msg) {
    return new ResultDataListModel(code, msg);
  }
}
