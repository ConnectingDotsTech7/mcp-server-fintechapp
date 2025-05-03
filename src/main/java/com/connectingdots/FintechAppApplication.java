package com.connectingdots;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FintechAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(FintechAppApplication.class, args);
    }

    @Bean
    public ToolCallbackProvider bankApiTool(BankAPIService bankAPIService) {
        return MethodToolCallbackProvider.builder().toolObjects(bankAPIService).build();
    }
}
