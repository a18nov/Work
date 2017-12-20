public class Giant extends Pawn{

	int step;
	String type = "Giant";
	public Giant(String Name,char Player,Coordinate Coordinate,boolean Life){
		super(Name,Player,Coordinate,Life);
		step = 2;
	}
}