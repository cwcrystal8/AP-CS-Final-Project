public abstract class Candy implements Comparable<Candy>{
    private boolean isRegular; //stores whether the Candy is Regular or Special
    
    public boolean getIsRegular(){
	return isRegular; //accessor method for isRegular
    }

    public void setIsRegular(boolean bool){
	isRegular = bool; //mutator method for isRegular
    }
    
    public abstract int compareTo(Candy other); //necessary for Comparable<Candy> interface
    public abstract boolean equals(Candy other); //necessary for Comparable<Candy> interface
    public abstract String getType(); //accessor method for data field in subclasses
}
