package com.hcl.kn.kt.commonschemas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.StringWriter;

@SpringBootApplication
public class CommonSchemasApplication implements CommandLineRunner {

    @Autowired
    private Jaxb2Marshaller jaxb2Marshaller;

    public static void main(String[] args) {
        SpringApplication.run(CommonSchemasApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Customer customer =new Customer();
//        customer.setId(1);
//        customer.setName("kasun");
//        customer.setCity("colombo");
//        customer.setContactNo("0717401412");
//
//        StringWriter stringWriter =new StringWriter();
//        jaxb2Marshaller.marshal(customer, new StreamResult(stringWriter));
//
//        System.out.printf("XML->"+stringWriter.toString());

        File xmlFile =new File("src/main/resources/xml/customers.xml");

        JAXBContext jaxbContext;

        jaxbContext = JAXBContext.newInstance(Customer.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        Customer customer = (Customer) jaxbUnmarshaller.unmarshal(xmlFile);

        System.out.printf(customer.toString());
    }
}
