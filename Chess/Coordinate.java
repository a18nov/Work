public class Coordinate{
	int x;
	int y;
	
	public Coordinate(){
		this.x=x;
		this.y=y;
	}
	public Coordinate(Coordinate coordinate){
		this.x = coordinate.x;
		this.y = coordinate.y;
	}
	public void updateX(int newValueX){
		this.x=newValueX;
	}
	public void updateY(int newValueY){
		this.y=newValueY;
	}
	public void updateXY(int newValueX,int newValueY){
		this.x = newValueX;
		this.y = newValueY;
	}
}