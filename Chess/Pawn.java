public class Pawn extends Hero{

	int step;
	String type = "Pawn";
	public Pawn(String Name,char Player,Coordinate Coordinate,boolean Life){
		super(Name,Player,Coordinate,Life);
		step = 1;
	}

	public void move(char movementDirection,char user){
		switch(movementDirection){
			case 'F':{
				Forward(user);
				break;
			}
			case 'L':{
				Left(user);
				break;
			}
			case 'B':{
				Backward(user);
				break;
			}
			case 'R':{
				Right(user);
				break;
			}
		}
	}

	public void Forward(char user){
		switch(user){
			case 'A':{
				newCoordinate.x = coordinate.x-1;
				System.out.println(newCoordinate.x+","+coordinate.x);
				break;
			}
			case 'B':{
				newCoordinate.x = coordinate.x+1;
				break;
			}
		}
	}

}