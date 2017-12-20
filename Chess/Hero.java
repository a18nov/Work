public abstract class Hero{
	String name;
	char player;
	Coordinate coordinate = new Coordinate();
	Coordinate newCoordinate = new Coordinate();
	boolean life;

	public Hero(String Name,char Player,Coordinate Coordinate,boolean Life){
		name = Name;
		player = Player;
		coordinate = Coordinate;
		newCoordinate = Coordinate;
		life = Life;
	}

	public abstract void move(char moveDirection,char user);

	public void Forward(char user){
		switch(user){
			case 'A':{
				newCoordinate.x = coordinate.x-1;
				break;
			}
			case 'B':{
				newCoordinate.x = coordinate.x+1;
				break;
			}
		}
	}

	public void Backward(char user){
		
	}

	public void Left(char user){
		
	}

	public void Right(char user){
		
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