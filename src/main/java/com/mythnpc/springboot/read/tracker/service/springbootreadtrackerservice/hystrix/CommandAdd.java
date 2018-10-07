package com.mythnpc.springboot.read.tracker.service.springbootreadtrackerservice.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

import org.tempuri.*;


public class CommandAdd extends HystrixCommand<Integer> {

    private final int a;
    private final int b;

    public CommandAdd(int a, int b) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("Add"))
        		.andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withCircuitBreakerForceOpen(true)));
        this.a = a;
        this.b = b;
    }

    @Override
    protected Integer run() {
    	
    	/* simulate performing network call*/
        try {
            Thread.sleep((int) (Math.random() * 20) + 5);
        } catch (InterruptedException e) {
            // do nothing
        }

        if (Math.random() > 0.6) {
            throw new RuntimeException("random failure loading payment information over network");
        }

        if (Math.random() > 0.9) {
            // random latency spike
            try {
                Thread.sleep((int) (Math.random() * 100) + 25);
            } catch (InterruptedException e) {
                // do nothing
            }
        }
    	
    	
  	    Calculator c = new Calculator();
	 
 	    CalculatorSoap cs = c.getCalculatorSoap();
 	    int total = cs.add(this.a, this.b);
        return total;
    }
    

    @Override
    protected Integer getFallback() {
        return 999999;
    }
}