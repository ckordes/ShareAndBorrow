package com.ckordes.ShareAndBorrow;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@ServletComponentScan
@SpringBootApplication
public class ShareAndBorrowApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(ShareAndBorrowApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ShareAndBorrowApplication.class);
    }
}