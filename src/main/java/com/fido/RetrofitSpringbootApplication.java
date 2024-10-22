package com.fido;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@SpringBootApplication
@EnableAsync
public class RetrofitSpringbootApplication implements AsyncConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(RetrofitSpringbootApplication.class, args);
    }



    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(500);
        executor.setMaxPoolSize(5000);
        executor.setQueueCapacity(100000);
        executor.setThreadNamePrefix("ThreadExecutor");
        executor.initialize();
        return executor;
    }
}
