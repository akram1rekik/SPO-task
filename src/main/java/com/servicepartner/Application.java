package com.servicepartner;

import com.servicepartner.dispatcher.OptimizationRequestDispatcher;
import com.servicepartner.optimizer.Optimizer;
import com.servicepartner.optimizer.SimplexOptimizerImpl;
import com.servicepartner.service.OptimizerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.servicepartner")
@SpringBootApplication
public class Application {


    @Bean
    public Optimizer optimizer() {
        return new SimplexOptimizerImpl();
    }

    @Bean
    public OptimizerService service() {
        Optimizer o = optimizer();
        return new OptimizerService(o);
    }

    @Bean
    public OptimizationRequestDispatcher dispatcher() {
        OptimizerService s = service();
        return new OptimizationRequestDispatcher(s);
    }

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }
}

