public class RegularCandy extends Candy{
    private String type; //stores the type of RegularCandy

    public RegularCandy(){
	this((int)(Math.random() * 10) % 5); //Creates a random Regular Candy
    }

    public RegularCandy(int n){
	setIsRegular(true);
	String[] types = {"Marshmallow","JellyBean","GumDrop","JollyRancher","Skittle"};
	type = types[n]; //Creates a Regular Candy whose type is determined by n
    }

    public String getType(){
	return type; //accessor method for type
    }

    public int useSpecialPower(){
	return 0;
    }

    public int compareTo(Candy other){
	return 0; //unnecessary method
    }

    public boolean equals(Candy other){
	return type == other.getType(); //returns true if the types are the same
    }

    public int getScoreWorth(){
	return 30; //each regular Candy is worth 30 points
    }

    public static void main(String[] args){
	//Test for random constructor
	RegularCandy a = new RegularCandy();
	System.out.println("a: " + a.getType());
	System.out.println(a.getScoreWorth());
	    
	//Test for specific constructor
	for(int i = 0; i < 5; i++){
	    RegularCandy b = new RegularCandy(i);
	    System.out.println("b: " + b.getType()); //Test for getType()
	    System.out.println(a.equals(b)); //Test for equals(Candy other)
	    System.out.println(b.equals(a)); //Test to check if reverse gives the same result, should match the output of the previous line of code
	    System.out.println(b.getScoreWorth()); //Test for getScoreWorth() method, should return 30
	}
    }
    
}
