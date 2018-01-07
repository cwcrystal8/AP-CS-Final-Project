public abstract class SpecialCandy extends Candy{
    private int scoreWorth;
    private String type;

    public void setType(String typ){
	type = typ;
    }

    public String getType(){
	return type;
    }

    public void setScoreWorth(int worth){
	scoreWorth = worth;
    }

    public int getScoreWorth(){
	return scoreWorth;
    }

}
