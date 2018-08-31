import java.util.ArrayList;
import java.util.List;

/**
 * This class is the Bin object.
 */
public class Bin {

	private int size; // current size of the bin - depends on the items it's currently holding
    private int maxSize; // max （fixed）size of the bin
    private List<Integer> items; // list of items in the bin

    /*
     * Constructor method for bin creation
     */
    public Bin(int maxSizeIn) {
        
		size = 0;
		maxSize = maxSizeIn;
        items = new ArrayList<Integer>();
    }

	/*
     * getter method for the number of items inside the current bin
     */
    public int getNumItems() {
        return items.size();
    }
		
    /*
     * Getter method that adds the newItem to the current bin if it can fit and return true, return false if it can't fit
     */
    public boolean canFit(Integer newItem) {
		
		boolean boo = true; // control variable for determining if the new item can fit in the current bin
		
        if (size + newItem <= maxSize) {
            items.add(newItem);
            size += newItem;
			boo = true; // can fit
        } else {
            boo = false; // too fat
        }
		return boo;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < items.size(); i++) {
            result += items.get(i) + " ";
        }
        result += "\tBin Current Size: " + size + "\tBin Max Size: " + maxSize;
        return result;
    }
}
