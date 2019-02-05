package com.servicepartner.tests;

import com.servicepartner.optimizer.Optimizer;
import com.servicepartner.optimizer.SimplexOptimizerImpl;
import com.servicepartner.pojos.Input;
import com.servicepartner.pojos.Output;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class OptimizerTest {


    @Test
    public void testOptimization() {

        Optimizer s = new SimplexOptimizerImpl();
        List<Integer> r = new ArrayList<>();
        r.add(24);
        Input input = new Input().withDataJunior(6).withDataSenior(11).withRooms(r);
        List<Output> outputs = s.find(input);

        assertThat(outputs.get(0).getJuniorAssociate(), comparesEqualTo(1));
        assertThat(outputs.get(0).getSeniorAssociate(), comparesEqualTo(2));
    }

    @Test
    public void testOptimizationZeroCapacity() {

        SimplexOptimizerImpl s = new SimplexOptimizerImpl();
        List<Integer> r = new ArrayList<>(Arrays.asList(0, 0, 0));
        Input input = new Input().withDataJunior(6).withDataSenior(10).withRooms(r);
        List<Output> outputs = s.find(input);

        assertThat(outputs.get(0).getJuniorAssociate(), comparesEqualTo(0));
        assertThat(outputs.get(0).getSeniorAssociate(), comparesEqualTo(0));

        assertThat(outputs.get(0).getJuniorAssociate(), comparesEqualTo(0));
        assertThat(outputs.get(0).getSeniorAssociate(), comparesEqualTo(0));
    }
}

