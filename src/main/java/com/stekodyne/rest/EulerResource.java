package com.stekodyne.rest;

import com.stekodyne.domain.Message;
import com.stekodyne.euler.One;

import restx.annotations.GET;
import restx.annotations.RestxResource;
import restx.factory.Component;
import restx.security.PermitAll;
import org.slf4j.profiler.Profiler;

@Component @RestxResource
public class EulerResource {
	// Setting up the profiler to calculate the compute time of the
	// methods.
	Profiler profiler = null;
	
	EulerResource() {
		profiler = new Profiler("Service");
	}

    /**
     * Simple end-point to sum the multiples of 3 and 5 to
     * a given point.
     * 
     * Does not require authentication.
     *
     * @return a Message to with the solution and profiling statistics.
     */
    @GET("/one/{upto}")
    @PermitAll
    public Message calculateEuler(long upto) {
    	long sum = 0;
    	
    	profiler.start("Time to compute Project Euler problem 1");
    	
    	sum = One.run(upto);
    		
    	profiler.stop();
    	
        return new Message(sum, new String().format("%s nanoseconds", profiler.getCopyOfChildTimeInstruments().get(0).toString()));
    }

}
