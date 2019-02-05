package com.servicepartner.service;

import com.servicepartner.optimizer.Optimizer;
import com.servicepartner.pojos.Input;
import com.servicepartner.pojos.Output;
import com.servicepartner.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.util.List;

@Service
public class OptimizerService {

    private Optimizer optimizer;

    @Autowired
    public OptimizerService(Optimizer optimizer) {
        this.optimizer = optimizer;
    }

    public ResponseEntity<?> optimize(String input) {
        try {
            Input i = MapperUtil.generateJsonStringToPojoForRequest(input, Input.class);
            List<Output> o = optimizer.find(i);
            return ResponseEntity.ok(o);
        } catch (ParseException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

    }
}