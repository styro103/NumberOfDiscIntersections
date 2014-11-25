/*
 * The class that determines how many intersections occurs with a set of discs.
 * This has a time complexity of O(N*log(N)).
 */

import java.util.Arrays; //For Sorting Arrays and Searching in Them

class Discs 
{
	public int getIntersections(int [] A)
	{
		//Edge Cases
		if (A.length<2)
			return 0;
		else if (A.length==2) //If Only Two
		{
			//Base Case
			if (1<=(long)A[0]+A[1]) //Check If Two Discs Intersect, Return Result
				return 1;
			else
				return 0;
		}
		
		long count = 0; //Count of Intersections
		int N = A.length; //Length of Array
		long [] sp = new long[N]; //Array to Hold Start Points on Plane
	    long [] ep = new long[N]; //Array to Hold End Points on Plane
		
		for (int i=0; i<N; i++) //Fill Point Arrays
		{
			sp[i] = i-A[i];
			ep[i] = (long) i+A[i];
		}
		 
		Arrays.sort(sp); //Sort Using Built in Function
		Arrays.sort(ep); //Sort Using Built in Function
		
		for (int i=N-1; i>-1; i--) //Check Each Disc
		{
			int pos = Arrays.binarySearch(sp, ep[i]); //Get Rank of Ending Point in Starting Points Array
			
			if(pos>-1) //If Located in Starting Points Array
			{
				while(pos<N && sp[pos]==ep[i])
					pos++; //Increment Position Till Reach Disc Who Starts at End Point
				
				count += pos; //Increment Number of Intersections With Discs Before
		    }
			else //If Not
				count += -(pos+1); //Increment Number of Intersections
		}
		
	    count -= (long) N*(N+1)/2; //Subtract Things Counted Twice and Degenerate Solutions
	    
	    if (count>10000000) //If Count Exceeds Limit
	    	return -1; //Return Special Case Result

		return (int) count; //Return Count
	}
}
