package com.servicepartner.dispatcher;

import com.servicepartner.service.OptimizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class OptimizationRequestDispatcher implements Dispatcher {

    private OptimizerService service;

    @Autowired
    public OptimizationRequestDispatcher(OptimizerService s) {
        this.service = s;
    }

    @Override
    public ResponseEntity<?> dispatchRequest(String input) {

        return service.optimize(input);
    }
}
