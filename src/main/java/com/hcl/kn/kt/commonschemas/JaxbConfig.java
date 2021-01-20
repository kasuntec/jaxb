package com.hcl.kn.kt.commonschemas;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import javax.xml.bind.Marshaller;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class JaxbConfig {

    @Bean
    public Jaxb2Marshaller jaxb2Marshaller(@Value("${context.path}") final String contextPath,
                                           @Value("${schema.location}") final Resource schema){

        Jaxb2Marshaller jaxb2Marshaller =new Jaxb2Marshaller();
        jaxb2Marshaller.setContextPath(contextPath);
        jaxb2Marshaller.setSchema(schema);

        Map<String, Object> propties =new HashMap<>();
        propties.put(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxb2Marshaller.setMarshallerProperties(propties);

        return jaxb2Marshaller;
    }
}
