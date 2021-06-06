package com.fastjrun.apiworld.sdkg.generator;

import com.fastjrun.apiworld.sdkg.generator.method.ApiWorldHTTPMethodGenerator;
import com.fastjrun.apiworld.sdkg.generator.processor.ApiWorldRequestProcessor;
import com.fastjrun.apiworld.sdkg.generator.processor.ApiWorldResponseProcessor;
import com.fastjrun.codeg.generator.BaseHTTPGenerator;
import com.fastjrun.codeg.generator.method.BaseControllerMethodGenerator;
import com.fastjrun.codeg.generator.method.BaseHTTPMethodGenerator;
import com.fastjrun.codeg.generator.method.ServiceMethodGenerator;
import com.fastjrun.codeg.processer.BaseRequestProcessor;
import com.fastjrun.codeg.processer.BaseResponseProcessor;
import com.fastjrun.codeg.processer.DefaultExchangeProcessor;

public class ApiWorldHTTPGenerator extends BaseHTTPGenerator {
    static final String WEB_PACKAGE_NAME = "web.apiworld.controller.";

    public ApiWorldHTTPGenerator() {
        this.webPackageName = WEB_PACKAGE_NAME;
    }

    @Override
    public BaseControllerMethodGenerator prepareBaseControllerMethodGenerator(
            ServiceMethodGenerator serviceMethodGenerator) {
        BaseHTTPMethodGenerator baseHTTPMethodGenerator = new ApiWorldHTTPMethodGenerator();
        baseHTTPMethodGenerator.setClient(this.isClient());
        baseHTTPMethodGenerator.setPackageNamePrefix(this.packageNamePrefix);
        baseHTTPMethodGenerator.setMockModel(this.mockModel);
        baseHTTPMethodGenerator.setServiceMethodGenerator(serviceMethodGenerator);
        baseHTTPMethodGenerator.setBaseControllerGenerator(this);
        BaseRequestProcessor baseRequestProcessor = new ApiWorldRequestProcessor();
        BaseResponseProcessor baseResponseProcessor = new ApiWorldResponseProcessor();
        DefaultExchangeProcessor<ApiWorldRequestProcessor, ApiWorldResponseProcessor> exchangeProcessor =
                new DefaultExchangeProcessor
                        (baseRequestProcessor,
                                baseResponseProcessor);
        exchangeProcessor.doParse(serviceMethodGenerator, this.packageNamePrefix);
        baseHTTPMethodGenerator.setExchangeProcessor(exchangeProcessor);
        return baseHTTPMethodGenerator;
    }
}
