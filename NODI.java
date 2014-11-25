/*
 * Shaun Mbateng
 * Number of Disc Intersections
 * This program finds the number of discs that intersect given the number of discs, their locations,
 * 	and their radii.
 * It has two solutions. One with a run time of O(N), and the other O(N*log(N)).
 */

import java.util.Scanner;

public class NODI 
{
	public static void main(String[] args) 
	{
		Scanner cin = new Scanner(System.in); //For Inputs
		Discs Plane1 = new Discs();
		DiscsCounters Plane2 = new DiscsCounters();
		int [] arr; //Array to Sort
		int len; //Length of Array
		int noi1; //Count Number of Intersections
		int noi2; //Count Number of Intersections
		
		//Enter and Set Array Length
		System.out.print("Enter the Array Length: ");
		len = cin.nextInt();
		arr = new int [len];
		
		//Fill Array
		for (int i=0; i<len; i++)
		{
			System.out.print("Enter Element "+(i+1)+": ");
			arr[i] = cin.nextInt();
		}
				
		cin.close(); //No More Inputs Needed
		noi1 = Plane1.getIntersections(arr);
		noi2 = Plane2.getIntersections(arr);
		System.out.println(); //Print Line Space
		
		//Print Result
		if (noi1==noi2)
			System.out.println("Number of Intersections: "+noi1); //Print Number of Intersections
		else //Shouldn't Happen, Just in Case
		{
			System.out.println("Error");
			System.out.println("Number of Intersections 1: "+noi1); //Print Number of Intersections 1
			System.out.println("Number of Intersections 2: "+noi2); //Print Number of Intersections 2
		}
	}

}
