package com.servicepartner.dispatcher;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface Dispatcher {

    ResponseEntity dispatchRequest(String input);
}
