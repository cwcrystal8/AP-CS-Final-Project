public class FiveInARow extends SpecialCandy{
    private String candyType;

    public FiveInARow(String canTyp){
	candyType = canTyp;
	setType("FiveInARow");
	setScoreWorth(500);
    }

    
    private void clearAllSameType(){
	System.out.println("You just cleared all the candies of one type!");
    }

    public String getCandyType(){
	return candyType;
    }

    public void setCandyType(String cantype){
	candyType = cantype;
    }

    public void useSpecialPower(){
	clearAllSameType();
    }


    public static void main(String[] args){
	FiveInARow a = new FiveInARow("JellyBean"), b = new FiveInARow("GumDrop");
	RegularCandy c = new RegularCandy();
	

	System.out.println(a.getCandyType());
	a.setCandyType("GumDrop");
	System.out.println(a.getCandyType());
	a.useSpecialPower();
	System.out.println(a.getCandyType());
	System.out.println(a.getScoreWorth());
	System.out.println(a.equals(b));
	System.out.println(b.equals(a));
	System.out.println(a.equals(c));
	System.out.println(c.equals(a));
	
    }
    
}
