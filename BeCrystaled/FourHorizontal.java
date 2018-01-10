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
    }

    public void setYCor(int y){
    }

    public void useSpecialPower(){
    }

    



}
