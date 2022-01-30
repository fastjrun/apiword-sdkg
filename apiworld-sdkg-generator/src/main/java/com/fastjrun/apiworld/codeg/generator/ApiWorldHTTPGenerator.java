package com.fastjrun.apiworld.codeg.generator;

import com.fastjrun.apiworld.codeg.generator.method.ApiWorldHTTPMethodGenerator;
import com.fastjrun.apiworld.codeg.generator.processor.ApiWorldRequestProcessor;
import com.fastjrun.apiworld.codeg.generator.processor.ApiWorldResponseProcessor;
import com.fastjrun.codeg.generator.BaseHTTPGenerator;
import com.fastjrun.codeg.generator.method.BaseControllerMethodGenerator;
import com.fastjrun.codeg.generator.method.BaseHTTPMethodGenerator;
import com.fastjrun.codeg.generator.method.BaseServiceMethodGenerator;
import com.fastjrun.codeg.processor.BaseRequestProcessor;
import com.fastjrun.codeg.processor.BaseResponseProcessor;
import com.fastjrun.codeg.processor.DefaultExchangeProcessor;

public class ApiWorldHTTPGenerator extends BaseHTTPGenerator {
  @Override
  public BaseControllerMethodGenerator prepareBaseControllerMethodGenerator(
      BaseServiceMethodGenerator serviceMethodGenerator) {
    BaseHTTPMethodGenerator baseHTTPMethodGenerator = new ApiWorldHTTPMethodGenerator();
    baseHTTPMethodGenerator.setClient(this.isClient());
    baseHTTPMethodGenerator.setPackageNamePrefix(this.packageNamePrefix);
    baseHTTPMethodGenerator.setMockModel(this.mockModel);
    baseHTTPMethodGenerator.setServiceMethodGenerator(serviceMethodGenerator);
    baseHTTPMethodGenerator.setBaseControllerGenerator(this);
    BaseRequestProcessor baseRequestProcessor = new ApiWorldRequestProcessor();
    BaseResponseProcessor baseResponseProcessor = new ApiWorldResponseProcessor();
    DefaultExchangeProcessor<ApiWorldRequestProcessor, ApiWorldResponseProcessor>
        exchangeProcessor =
            new DefaultExchangeProcessor(baseRequestProcessor, baseResponseProcessor);
    exchangeProcessor.doParse(serviceMethodGenerator, this.packageNamePrefix);
    baseHTTPMethodGenerator.setExchangeProcessor(exchangeProcessor);
    return baseHTTPMethodGenerator;
  }
}
