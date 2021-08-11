package com.fastjrun.apiworld.helper;

import com.fastjrun.apiworld.common.ApiWorldCodeMsgConstants;
import com.fastjrun.apiworld.dto.ResultPageModel;
import com.fastjrun.apiworld.dto.ResultListModel;
import com.fastjrun.apiworld.dto.ResultModel;
import com.fastjrun.dto.PageResult;

import java.util.List;

public class ResultHelper {

  public static <T> ResultModel<T> ok() {
    return result(ApiWorldCodeMsgConstants.SWCodeEnum.OK);
  }

  public static <T> ResultModel<T> ok(T result) {
    return result(ApiWorldCodeMsgConstants.SWCodeEnum.OK, result);
  }

  public static <T> ResultModel<T> fail(ApiWorldCodeMsgConstants.SWCodeEnum code) {
    return result(code);
  }

  public static <T> ResultModel<T> result(ApiWorldCodeMsgConstants.SWCodeEnum code) {
    return result(code, null);
  }

  public static <T> ResultModel<T> result(ApiWorldCodeMsgConstants.SWCodeEnum code, T result) {
    return new ResultModel(code.getCode(), code.getMsg(), result);
  }

  public static <T> ResultModel<T> fail(String code, String msg) {
    return new ResultModel(code, msg);
  }

  public static <T> ResultListModel<T> okList() {
    return resultList(ApiWorldCodeMsgConstants.SWCodeEnum.OK);
  }

  public static <T> ResultListModel<T> okList(List<T> result) {
    return resultList(ApiWorldCodeMsgConstants.SWCodeEnum.OK, result);
  }

  public static <T> ResultListModel<T> failList(ApiWorldCodeMsgConstants.SWCodeEnum code) {
    return resultList(code);
  }

  public static <T> ResultListModel<T> resultList(ApiWorldCodeMsgConstants.SWCodeEnum code) {
    return resultList(code, null);
  }

  public static <T> ResultListModel<T> resultList(
      ApiWorldCodeMsgConstants.SWCodeEnum code, List<T> result) {
    return new ResultListModel(code.getCode(), code.getMsg(), result);
  }

  public static <T> ResultListModel<T> failList(String code, String msg) {
    return new ResultListModel(code, msg);
  }

  public static <T> ResultPageModel<T> okPage() {
    return resultPage(ApiWorldCodeMsgConstants.SWCodeEnum.OK);
  }

  public static <T> ResultPageModel<T> okPage(PageResult<T> result) {
    return resultPage(ApiWorldCodeMsgConstants.SWCodeEnum.OK, result);
  }

  public static <T> ResultPageModel<T> failPage(ApiWorldCodeMsgConstants.SWCodeEnum code) {
    return resultPage(code);
  }

  public static <T> ResultPageModel<T> resultPage(ApiWorldCodeMsgConstants.SWCodeEnum code) {
    return resultPage(code, null);
  }

  public static <T> ResultPageModel<T> resultPage(
      ApiWorldCodeMsgConstants.SWCodeEnum code, PageResult<T> result) {
    return new ResultPageModel(code.getCode(), code.getMsg(), result);
  }

  public static <T> ResultPageModel<T> failPage(String code, String msg) {
    return new ResultPageModel(code, msg);
  }
}
