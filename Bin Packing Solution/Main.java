
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
		
		System.out.println("BinPacking Algorithm - First Fit Decreasing Method");
        System.out.println("Please Enter the Number of Integers in the Bin: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // scan number of items
		
        System.out.println("Please Enter "+n+" Integers(with a space in between numbers):");
		List<Integer> input = new ArrayList<Integer>();
        for(int i=0; i<n; i++)
            input.add(sc.nextInt());
		
		
        // scan bin size
		System.out.println("Please Enter the Max Bin Size:");
        int binSize = sc.nextInt();
        sc.close();

		// Method constructor; Create the algorithm object with input parameters
        Algorithm alg = new Algorithm(input, binSize);
        
		// process the packing
		packing(alg);
    }

    private static void packing(Algorithm alg) {
		
        long beginTimeMs;                                  
        long processedTimeMs;
		long beginTimeNs;
		long processedTimeNs;

		// Begin time tracking
		beginTimeNs = System.nanoTime();
		beginTimeMs = beginTimeNs / 1000000;
		
		// Process the alg
		System.out.println("---------------------Results-------------------\n");
        System.out.println("Total number of Bins required: " + alg.getNumBins() + "\n");
        alg.getResults();
		
		// Calling the system again after the alg method to get the time used
		processedTimeNs = System.nanoTime() - beginTimeNs; 
		processedTimeMs = processedTimeNs / 1000000;
		
		// System.out.println(beginTimeMs);
        System.out.println("Processed in " + processedTimeMs + " ms or " + processedTimeNs + " ns" );

    }

}
