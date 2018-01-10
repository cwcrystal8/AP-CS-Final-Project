public class FourVertical extends SpecialCandy{
    private int xcor;

    public FourVertical(int x){
	xcor = x;
	setType("FourVertical");
	setScoreWorth(300);
    }


    private void clearVertical(){
	System.out.println("You just cleared a column!"); //Temp line, to be replaced later
    }

    public int getXCor(){
	return xcor;
    }

    public void setXCor(int x){
	xcor = x;
    }

    public void useSpecialPower(){
	clearVertical();
    }

    public static void main(String[] args){
	FourVertical a = new FourVertical(5), b = new FourVertical(6);
	RegularCandy c = new RegularCandy();
	

	System.out.println(a.getXCor());
	a.setXCor(8);
	System.out.println(a.getXCor());
	a.useSpecialPower();
	System.out.println(a.getType());
	System.out.println(a.getScoreWorth());
	System.out.println(a.equals(b));
	System.out.println(b.equals(a));
	System.out.println(a.equals(c));
	System.out.println(c.equals(a));
	
    }
}
