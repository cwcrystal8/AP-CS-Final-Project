public class FiveInARow extends SpecialCandy{
    private int xcor;
    private int ycor;

    public FiveInARow(int x, int y){
	xcor = x;
	ycor = y;
	setType("FiveInARow");
	setScoreWorth(500);
	setIsRegular(false);
    }


    public int getXCor(){
	return xcor;
    }

    public int getYCor(){
	return ycor;
    }

    public void setYCor(int y){
	ycor = y;
    }

    public void setXCor(int x){
	xcor = x;
    }

    public int useSpecialPower(){
	return 3;
    }


    public static void main(String[] args){
	FiveInARow a = new FiveInARow(5,6), b = new FiveInARow(7,8);
	RegularCandy c = new RegularCandy();
	

	System.out.println(a.getXCor());
	System.out.println(a.getYCor());
	a.setXCor(8);
	a.setYCor(9);
	System.out.println(a.getXCor());
	System.out.println(a.getYCor());
	a.useSpecialPower();
	System.out.println(a.getType());
	System.out.println(a.getScoreWorth());
	System.out.println(a.equals(b));
	System.out.println(b.equals(a));
	System.out.println(a.equals(c));
	System.out.println(c.equals(a));
	
    }
    
}
