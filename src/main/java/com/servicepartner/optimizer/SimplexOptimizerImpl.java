package com.servicepartner.optimizer;

import com.servicepartner.pojos.Input;
import com.servicepartner.pojos.Output;
import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/*
 *  Uses Simplex method to solve optimization problem with Choco Solver.
 */

@Component
public class SimplexOptimizerImpl implements Optimizer {

    private static final int MAX_AVAILABLE_SENIOR_CAPACITY = 1000;
    private static final int MAX_AVAILABLE_JUNIOR_CAPACITY = 1000;

    @Override
    public List<Output> find(Input input) {

        List<Output> outputs = new ArrayList<>();
        Model model;
        IntVar x;
        IntVar y;
        IntVar obj;
        int globalMin;
        int xSol;
        int ySol;

        for (int iter = 0; iter <= input.getRooms().size()-1; iter++) {


            //Simplex Optimizer
            // X variable -> Senior
            // Y variable -> Junior

            model = new Model("Simplex Optimizer");
            x = model.intVar("X", 1, MAX_AVAILABLE_SENIOR_CAPACITY);
            y = model.intVar("Y", 0, MAX_AVAILABLE_JUNIOR_CAPACITY);

            //Global Minimum
            globalMin = Integer.MAX_VALUE;
            xSol = 0;
            ySol = 0;

            //Define Objective Function ( seniorCapacity * X + juniorCapacity * Y)
            obj = model.intVar("objective", input.getRooms().get(iter), input.getRooms().get(iter) + input.getJunior());
            model.scalar(new IntVar[]{x, y}, new int[]{input.getSenior(), input.getJunior()}, "=", obj).post();
            model.setObjective(Model.MAXIMIZE, obj);

            //Define Objective Function ( seniorCapacity * X + juniorCapacity * Y >= Room Capacity
            x.mul(input.getSenior()).add(y.mul(input.getJunior())).ge(input.getRooms().get(iter)).post();

            //Define Objective Function ( seniorCapacity * X + juniorCapacity * Y <= Room Capacity + Junior capacity
            x.mul(input.getSenior()).add(y.mul(input.getJunior())).le(input.getRooms().get(iter) + input.getJunior()).post();
            x.ge(1).post();
            y.ge(0).post();

            Solver s = model.getSolver();

            while (s.solve()) {
                Solution solutions = s.findSolution();
                if (solutions != null && obj.getValue() < globalMin) {
                    xSol = x.getValue();
                    ySol = y.getValue();
                    globalMin = obj.getValue();
                }
            }
            outputs.add(new Output().withSeniorAssociate(xSol).withJuniorAssociate(ySol));
        }
        return outputs;
    }

}
