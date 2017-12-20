public class ChessBoard{
	
	public static String board[][] = new String[5][5];
	public static Hero[] A = new Hero[5];
	public static Hero[] B = new Hero[5];
	public static int scoreA=0,scoreB=0;
	private static int i,j;

	public static void initChessBoard(){
		for(i=0;i<5;i++)
			for(j=0;j<5;j++)
				board[i][j] = "-";
	}

	public static void predictMove(Hero hero,char movement){
		hero.move(movement,hero.player);
		if(isOutOfBoard(hero.coordinate)){
			System.out.println("Error : Move out of board!");
		}
		else if(isAllyPresent(hero.coordinate,hero.newCoordinate)) {
			System.out.println(hero.coordinate.x+","+hero.coordinate.y+",\t"+hero.newCoordinate.x+","+hero.newCoordinate.y);
			System.out.println("Error : Ally hero present!");
		}
		else if(isEmpty(hero.coordinate,hero.newCoordinate)) {
			swapPlaces(hero);
		}
		else{
			Hero toKill = findHero(hero.newCoordinate);
			toKill.killSelf();
			swapPlaces(hero);
		}
	}

	public static boolean isAllyPresent(Coordinate coordinate,Coordinate updatedCoordinate){
		if(board[coordinate.x][coordinate.y].charAt(0)==board[updatedCoordinate.x][updatedCoordinate.y].charAt(0))
			return true;
		return false;
	}

	public static boolean isEmpty(Coordinate coordinate,Coordinate updatedCoordinate){
		if(board[updatedCoordinate.x][updatedCoordinate.y].compareTo("-")==0)
			return true;
		return false;
	}

	public static boolean isOutOfBoard(Coordinate coordinate){
		if(coordinate.x>5||coordinate.x<0||coordinate.y>5||coordinate.y<0)
			return true;
		return false;
	}

	public static void swapPlaces(Hero hero){
		board[hero.newCoordinate.x][hero.newCoordinate.y] = hero.player+"-"+hero.name;
		board[hero.coordinate.x][hero.coordinate.y] = "-";
		hero.coordinate = hero.newCoordinate;
	}

	public static Hero findHero(Coordinate coordinate){
		for(i=0;i<5;i++){
			if(A[i].coordinate == coordinate)
				return A[i];
		}
		for(i=0;i<5;i++){
			if(B[i].coordinate == coordinate)
				return A[i];
		}
		return null;
	}

	public static Hero findHeroByName(String name,char user){
		if(user=='A'){
			for(i=0;i<5;i++){
				if(A[i].name.compareTo(name)==0)
					return A[i];
			}
		}
		else{
			for(i=0;i<5;i++){
				if(B[i].name.compareTo(name)==0)
					return B[i];
			}
		}
		return null;
	}

	public static void displayBoard(){
		for (i=0;i<5;i++) {
			for (j=0;j<5;j++) {
				System.out.print(board[i][j]+"\t");
			}
			System.out.println();
		}
	}

	public static void displayScore(){
		System.out.println("\nPlayer A : "+scoreA+"\nPlayer B : "+scoreB);
	}
}