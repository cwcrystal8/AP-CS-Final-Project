public class RegularCandy extends Candy{
    private String type; //stores the type of RegularCandy

    public RegularCandy(){
	setIsRegular(true);
	//Creates a random Regular Candy
    }

    public RegularCandy(int n){
	//Creates a Regular Candy whose type is determined by n
    }

    public String getType(){
	return "";
    }

    public int compareTo(Candy other){
	return 0;
    }

    public boolean equals(Candy other){
	return true;
    }
    
}
