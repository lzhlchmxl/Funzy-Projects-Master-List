/*this class represents a temporary marker, and it inheritances the permanent class*/
public class TMarker extends PMarker{
	
	/** Constructs a new instance by using the parameters for the 
   	 column, height and position of the temporary marker.
	@param columnIn the column of the temporary marker 
	@param heightIn the height of the temporary marker 
	@param positionIn the position of the temporary marker **/
	public TMarker(int columnIn,int heightIn,int positionIn){

		super(columnIn,heightIn,positionIn);
	
	}

	/** Method to set the column of the temporary marker
	@param newColumn the new column of the temporary marker **/
	public void setColumn (int newColumn){

		column = newColumn;
	}

	/** Method to set the height of the temporary marker
	@param newHeight the new height of the temporary marker **/
	public void setHeight (int newHeight){

		height = newHeight;
	}

	/** Method to move forward the temporary marker by one uint and access whether the move conquer the column 
	@return conquer the boolean of conquer of the temporary marker,indicates whether this move conquers the column **/
	public boolean move(){
		
		boolean conquer = false;
		if(!this.getTop()){
			position++;
		}
		
		
		if(position == height){
			conquer = true;
		}
	
		return conquer;
	}

}
