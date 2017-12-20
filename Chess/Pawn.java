public class Pawn extends Hero{

	int step;
	String type = "Pawn";
	public Pawn(String Name,char Player,Coordinate Coordinate,boolean Life){
		super(Name,Player,Coordinate,Life);
		step = 1;
	}
}