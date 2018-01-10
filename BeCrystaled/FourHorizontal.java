public class FourHorizontal extends SpecialCandy{
    private int ycor;

    public FourHorizontal(int y){
	ycor = y;
	setType("FourHorizontal");
	setScoreWorth(300);
    }


    private void clearHorizontal(){
	System.out.println("You just cleared a row!");
    }

    public int getYCor(){
	return ycor;
    }

    public void setYCor(int y){
	ycor = y;
    }

    public void useSpecialPower(){
	clearHorizontal();
    }

    
    public static void main(String[] args){
	FourHorizontal a = new FourHorizontal(5), b = new FourHorizontal(6);
	RegularCandy c = new RegularCandy();
	

	System.out.println(a.getYCor());
	a.setYCor(8);
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
