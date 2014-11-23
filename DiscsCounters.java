/*
 * The class that determines how many intersections occurs with a set of discs using arrays of counters.
 * This has a time complexity of O(N).
 */

class DiscsCounters
{
	public int getIntersections(int [] A)
	{
		//Edge Cases
		if (A.length<2) //If Less Than Two Discs
			return 0; //No Intersections
		else if (A.length==2) //If Only Two
		{
			//Base Case
			if (1<=(long)A[0]+A[1]) //Check If Two Discs Intersect, Return Result
				return 1;
			else
				return 0;
		}
	        
	    int N = A.length; //Length of Array
	    int count = 0; //Number of Intersections
	    int [] dps = new int[N]; //Array to Hold Count of Values of Start Points on Plane
	    int [] dpe = new int[N]; //Array to Hold Count of Values of End Points on Plane
	    
	    for (int i=0; i<N; i++) //Walk Through Array
	    {
	    	dps[Math.max(0, i-A[i])]++; //Increment Count of Respective Start Point
	        dpe[(int)Math.min(N-1, (long)i+A[i])]++; //Increment Count of Respective End Point
	    }
	    
	    int t = 0; //Traverser
	     
	    for (int i=0; i<N; i++) //Walk Through Array
	    {
	        if (dps[i]>0) //If Start Point Isn't Zero
	        {
	        	count += t*dps[i]+dps[i]*(dps[i]-1)/2; //Increment Count by Number of Intersections at Respective Start Point
	             
	            if (count>10000000) //If More Than Number Allowed
	            	return -1; //Return -1, Indicate Too Big
	                 
	            t += dps[i]; //Increment Traverser by Start Point Count Value
	        }
	            
	        t -= dpe[i]; //Decrement Traverser by End Point Count Value
	    }   
	     
	    return count; //Return Count
	}
}