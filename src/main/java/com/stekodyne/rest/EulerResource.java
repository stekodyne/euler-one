package com.stekodyne.rest;

import com.stekodyne.domain.Message;
import restx.annotations.GET;
import restx.annotations.RestxResource;
import restx.factory.Component;
import restx.security.PermitAll;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.profiler.Profiler;

@Component @RestxResource
public class EulerResource {
	// Setting up the profiler to calculate the compute time of the
	// methods.
	Profiler profiler = null;
	
	EulerResource() {
		profiler = new Profiler("BASIC");
	}

    /**
     * Simple end-point to sum the multiples of 3 and 5 to
     * a given point.
     * 
     * Does not require authentication.
     *
     * @return a Message to with the sum.
     */
    @GET("/euler/1")
    @PermitAll
    public Message calculateEuler1(int upto) {
    	Integer sum = 0;
    	
    	profiler.start("Time complexity mn");
    	
    	if (upto > 0) {
    		List<Integer> values = new ArrayList<>();
    		
    		for (int i = 1; i * 3 < upto; i++) {
    			values.add(3 * i);
    		}
    		
    		for (int i = 1; 5 * i < upto; i++) {
    			values.add(5 * i);
    		}
    		
    		sum = values.stream().distinct().reduce(0, (a, b) -> a + b);
    		
    		profiler.stop();
    	}
    	
        return new Message(sum, profiler.toString());
    }

}
