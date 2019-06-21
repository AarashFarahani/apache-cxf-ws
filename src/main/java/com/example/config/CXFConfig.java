package com.example.config;

import javax.xml.ws.Endpoint;

import com.example.service.GreetingServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.wss4j.common.ConfigurationConstants;
import org.apache.wss4j.dom.WSConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.service.InfoServiceImpl;
import com.example.interceptors.AppInboundInterceptor;
import com.example.interceptors.AppOutboundInterceptor;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CXFConfig {
    @Autowired private CxfCallbackHandler cxfCallbackHandler;

	@Bean
	public ServletRegistrationBean dispatcherServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/services/*");
    }
	
    @Bean(name=Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {    
    	SpringBus springBus = new SpringBus();
        springBus.getInInterceptors().add(new AppInboundInterceptor());
    	springBus.getOutInterceptors().add(new AppOutboundInterceptor());
    	return springBus;
    }
    
    @Bean
    public Endpoint infoEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), new InfoServiceImpl());

        Map<String,Object> inProps = new HashMap<>();
        inProps.put(ConfigurationConstants.ACTION, ConfigurationConstants.USERNAME_TOKEN);
        inProps.put(ConfigurationConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
        inProps.put(ConfigurationConstants.PW_CALLBACK_REF, this.cxfCallbackHandler);
        endpoint.getInInterceptors().add(new WSS4JInInterceptor(inProps));

        endpoint.publish("/InfoService");
        return endpoint;
    }

    @Bean
    public Endpoint greetingEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), new GreetingServiceImpl());
        endpoint.publish("/GreetingService");
        return endpoint;
    }
}
