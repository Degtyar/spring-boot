package ru.degtyar.springboot.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
import ru.degtyar.springboot.endpoint.PersonEndpoint;

import javax.validation.constraints.NotNull;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
    @NotNull
    private static final String WS_MAPPING  = "/soap/*";

    @Bean
    public ServletRegistrationBean dispatcherServlet(ApplicationContext applicationContext){
        final MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, WS_MAPPING);
    }
    @Bean(name = "PersonSer")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema endpointSchema){
        final DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName(PersonEndpoint.PORT_TYPE_NAME);
        wsdl11Definition.setLocationUri(PersonEndpoint.LOCATION_URI);
        wsdl11Definition.setTargetNamespace(PersonEndpoint.NAMESPACE);
        wsdl11Definition.setSchema(endpointSchema);
        return wsdl11Definition;
    }
    @Bean
    public XsdSchema endpointSchema(){
        return new SimpleXsdSchema(new ClassPathResource("xsd/personEndpoint.xsd"));
    }
}