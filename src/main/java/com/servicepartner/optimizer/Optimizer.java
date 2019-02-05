package com.servicepartner.optimizer;

import com.servicepartner.pojos.Input;
import com.servicepartner.pojos.Output;

import java.util.List;

public interface Optimizer {

    List<Output> find(Input input);
}
