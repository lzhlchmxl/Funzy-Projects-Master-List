/*this class represents a permanent marker */
public class PMarker{
	/** The column number of the permanent marker **/
	protected int column;
	/** The height number of the permanent marker **/
	protected int height;
	/** The position number of the permanent marker **/
	protected int position;
	/** The boolean to show whether PMarker's column is conqured **/
	protected boolean top;

	/** Constructs a new instance by using the parameters for the 
   	 column, height and position of the permanent marker.
	@param columnIn the column of the permanent marker 
	@param heightIn the height of the permanent marker 
	@param positionIn the position of the permanent marker **/
	public PMarker(int columnIn,int heightIn,int positionIn){

		column = columnIn;
		height = heightIn;
		position = positionIn;
		top = false;
	
	}
	/** Accessor method for the conquer status permanent marker
	@return top the conquer status of the permanent marker **/	
	public boolean getTop(){
		return top;
	}
	/**method to set the conquer status of the permanent marker to true**/
	public void setTop(){
		top = true;
	}
	/**method to set the conquer status of the permanent marker to false**/
	public void clearTop(){

		top = false;
	}
	
	/** Accessor method for the height of the permanent marker
	@return the height of the permanent marker **/
	public int getHeight(){
		return height;
	}
	/** Accessor method for the column of the permanent marker
	@return the column of the permanent marker **/
	public int getColumn(){

		return column;
	}
	/** Accessor method for the position of the permanent marker
	@return the position of the permanent marker **/
	public int getPosition(){

		return position;

	}
	/** Method to set the position of the permanent marker
	@param newRow the new position of the permanent marker **/
	
	public void setPosition(int newRow){
		position = newRow;

	}
	/**method to show the status of the permanent marker
	@return status the String shows the status of the permanent marker **/
	public String toString(){

		String marker = "c "+ this.getColumn() + "  h "+ this.getHeight()+ "  p "+ this.getPosition();
		return marker;
	}

}
