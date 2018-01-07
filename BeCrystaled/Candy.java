public abstract class Candy implements Comparable<Candy>{
    private boolean isRegular;
    
    public boolean getIsRegular(){
	return isRegular;
    }

    public void setIsRegular(boolean bool){
	isRegular = bool;
    }
    
    public abstract int compareTo(Candy other);
    public abstract boolean equals(Candy other);
}
