
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class Algorithm {
	
	/*
	*	variables for constructing rhe algorithm
	*/
	private List<Integer> input;
    private int binSize;	
    private List<Bin> binList = new ArrayList<Bin>(); // list of bins

	/*
	* Constructor for the Algorithm
	*/
	public Algorithm(List<Integer> inputIn, int binSizeIn) {
        input = inputIn;
        binSize = binSizeIn;
    }

	/*
	*	This part of the algorithm puts the items in the bin and returns the total number of required bins
	*/
    public int getNumBins() {
		
		// Using collections to sort the input items in decending order  
        Collections.sort(input, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) { // the default comparator is in ascending order
                return o2 - o1;
            }
        });
		
        binList.add(new Bin(binSize));
        for (int i = 0; i < input.size(); i++ ) {
			
			Integer item = input.get(i); // current item
			int bin = 0; // initiate bin selector
            boolean fit = false; // boolean control for determining if the item fits in the current bin
            
			// System.out.println(bin);
			// System.out.println(binList.size());
			
			// keep looping as long as the item doesn't fit
            while (!fit) {
				
				// System.out.println(bin);
				// System.out.println(binList.size());
				
                if (bin == binList.size()) { // Note: bin starts at 0, binList size starts at 1, so even if the first item doesn't fit in the 
											 //  	first bin(skips second if), we will still loop back and deal with such item in this logic.
                    // item did not fit in last bin. put it in a new bin
                    Bin newBin = new Bin(binSize);
                    newBin.canFit(item); // Note: in the bin class, the item is added to the bin if it fits and does nothing if it doesnt fit.
                    binList.add(newBin);
                    fit = true;
                } else if (binList.get(bin).canFit(item)) {
                    fit = true; // the current item fits the current bin
                } else {
                    bin++; // Note: increase the index of the bin allows us to 'try' the next bin without actually changing/managing the bin
                }
            }
        }
        return binList.size();
    }

	/*
	*	Looping through each bin and print out the results by calling the to string method in the Bin Class
	*/
    public void getResults() {
		
		for (int i = 0; i < binList.size(); i++ ) {
			
			Bin bin = binList.get(i);
			System.out.println(bin.toString());
		}
		System.out.println(); // just to make the output look better
    }
}
