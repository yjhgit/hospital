package com.yayangchun.traditionalchinesemedicinemuseum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class TraditionalChineseMedicineMuseumApplication {

    public static void main(String[] args) {
        SpringApplication.run(TraditionalChineseMedicineMuseumApplication.class, args);
    }

}
