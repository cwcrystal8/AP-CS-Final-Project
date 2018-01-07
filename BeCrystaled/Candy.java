public abstract class Candy implements Comparable<Candy>{
    private boolean isRegular;
    
    public boolean getIsRegular(){
	return isRegular;
    }

    public abstract int compareTo(Candy other);
    public abstract boolean equals(Candy other);
}
