public abstract class SpecialCandy extends Candy{
    private int scoreWorth; //stores the points each SpecialCandy is worth
    private String type; //stores the type of SpecialCandy

    public void setType(String typ){
	type = typ; //mutator method for type
    }

    public String getType(){
	return type; //accessor method for type
    }

    public void setScoreWorth(int worth){
	scoreWorth = worth; //mutator method for scoreWorth
    }

    public int getScoreWorth(){
	return scoreWorth; //accessor method for scoreWorth
    }

    public int compareTo(Candy other){
	return getScoreWorth() - other.getScoreWorth();
    }

    public boolean equals(Candy other){
	return type == other.getType();
    }

    public abstract void useSpecialPower();
}
