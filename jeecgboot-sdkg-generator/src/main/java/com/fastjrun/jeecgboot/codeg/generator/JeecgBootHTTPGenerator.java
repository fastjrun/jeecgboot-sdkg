package com.fastjrun.jeecgboot.codeg.generator;

import com.fastjrun.jeecgboot.codeg.generator.method.JeecgBootHTTPMethodGenerator;
import com.fastjrun.jeecgboot.codeg.generator.processor.JeecgBootRequestProcessor;
import com.fastjrun.jeecgboot.codeg.generator.processor.JeecgBootResponseProcessor;
import com.fastjrun.codeg.generator.BaseHTTPGenerator;
import com.fastjrun.codeg.generator.method.BaseControllerMethodGenerator;
import com.fastjrun.codeg.generator.method.BaseHTTPMethodGenerator;
import com.fastjrun.codeg.generator.method.BaseServiceMethodGenerator;
import com.fastjrun.codeg.processor.BaseRequestProcessor;
import com.fastjrun.codeg.processor.BaseResponseProcessor;
import com.fastjrun.codeg.processor.DefaultExchangeProcessor;

public class JeecgBootHTTPGenerator extends BaseHTTPGenerator {
  @Override
  public BaseControllerMethodGenerator prepareBaseControllerMethodGenerator(
      BaseServiceMethodGenerator serviceMethodGenerator) {
    BaseHTTPMethodGenerator baseHTTPMethodGenerator = new JeecgBootHTTPMethodGenerator();
    baseHTTPMethodGenerator.setClient(this.isClient());
    baseHTTPMethodGenerator.setPackageNamePrefix(this.packageNamePrefix);
    baseHTTPMethodGenerator.setMockModel(this.mockModel);
    baseHTTPMethodGenerator.setServiceMethodGenerator(serviceMethodGenerator);
    baseHTTPMethodGenerator.setBaseControllerGenerator(this);
    BaseRequestProcessor baseRequestProcessor = new JeecgBootRequestProcessor();
    BaseResponseProcessor baseResponseProcessor = new JeecgBootResponseProcessor();
    DefaultExchangeProcessor<JeecgBootRequestProcessor, JeecgBootResponseProcessor>
        exchangeProcessor =
            new DefaultExchangeProcessor(baseRequestProcessor, baseResponseProcessor);
    exchangeProcessor.doParse(serviceMethodGenerator, this.packageNamePrefix);
    baseHTTPMethodGenerator.setExchangeProcessor(exchangeProcessor);
    return baseHTTPMethodGenerator;
  }
}
