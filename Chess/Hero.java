public abstract class Hero{
	String name;
	char player;
	Coordinate coordinate = new Coordinate();
	Coordinate newCoordinate = new Coordinate(coordinate);
	boolean life;

	public Hero(String Name,char Player,Coordinate Coordinate,boolean Life){
		name = Name;
		player = Player;
		coordinate = Coordinate;
		life = Life;
	}

	public void move(char user, char moveDirection){
		switch(moveDirection){
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
				newCoordinate.x = coordinate.x-hero.step;
				break;
			}
			case 'B':{
				newCoordinate.x = coordinate.x+hero.step;
				break;
			}
		}
	}
	public void Backward(char user){
		switch(user){
			case 'A':{
				newCoordinate.x = coordinate.x+hero.step;
				break;
			}
			case 'B':{
				newCoordinate.x = coordinate.x-hero.step;
				break;
			}
		}
	}
	public void Left(char user){
		switch(user){
			case 'A':{
				newCoordinate.y = coordinate.y-hero.step;
				break;
			}
			case 'B':{
				newCoordinate.y = coordinate.y+hero.step;
				break;
			}
		}
		
	}
	public void Right(char user){
		switch(user){
			case 'A':{
				newCoordinate.y = coordinate.y+hero.step;
				break;
			}
			case 'B':{
				newCoordinate.y = coordinate.y-hero.step;
				break;
			}
		}
	}

	public void ForwardLeft(){

	}

	public void ForwardRight(){

	}

	public void BackwardLeft(){

	}

	public void BackwardRight(){

	}

	public boolean isAlive(){
		return life;
	}

	public void updateCoordinate(char movement){

	}

	public void killSelf(){
		life = false;
	}
}