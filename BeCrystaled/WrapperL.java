public class WrapperL extends SpecialCandy{
    private int xcor;
    private int ycor;

    public WrapperL(int x, int y){
	xcor = x;
	ycor = y;
	setType("WrapperL");
	setScoreWorth(400);
    }

    
    private void clearSquare(){
	System.out.println("You just cleared a square!");
    }

    public int getXCor(){
	return xcor;
    }

    public int getYCor(){
	return ycor;
    }

    public void setXCor(int x){
	xcor = x;
    }

    public void setYCor(int y){
	ycor = y;
    }

    public void useSpecialPower(){
	clearSquare();
    }


    
    public static void main(String[] args){
	WrapperL a = new WrapperL(5,6), b = new WrapperL(7,8);
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
