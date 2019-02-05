package com.servicepartner.controller;

import com.servicepartner.dispatcher.OptimizationRequestDispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RestApiController {

    @Autowired
    private OptimizationRequestDispatcher dispatcher;

    @RequestMapping(value = "/optimize", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> runOptimize(@RequestBody String body) throws Exception {

        return dispatcher.dispatchRequest(body);
    }
}
