import java.util.*;
public class Play extends ChessBoard{
	static Scanner in = new Scanner(System.in);
	static int i,j;
	static String input;
	static char t;

	public static void main(String[] args) {
		initChessBoard();
		inputHero('A');
		displayBoard();
		inputHero('B');
		displayBoard();
		playGame();
	}

	public static void playGame(){
		while(scoreA<5||scoreB<5){
			playerMove('A');
			playerMove('B');
		}
	}

	public static void playerMove(char user){
		System.out.println("Enter hero to move for Player "+user+" : ");
		input = in.nextLine();
		while(!checkName(input,user)){
			System.out.println("No such hero for A. Please re-enter : ");
			input = in.nextLine();
		}
		System.out.println("Enter direction : ");
		t = Character.toUpperCase(in.nextLine().trim().charAt(0));
		while(t!='F'&&t!='B'&&t!='L'&&t!='R'){
			System.out.println("No such direction. Please re-enter : ");
			t = Character.toUpperCase(in.nextLine().trim().charAt(0));
		}
		moveHandler(user,findHeroByName(input,user),t);
	}

	public static void moveHandler(char user,Hero hero,char direction){
		System.out.println("Inside moveHandler"+hero.name+","+user);
		predictMove(hero,direction);
		displayBoard();
	}
	

	public static boolean checkName(String nameToFind,char user){
		if(user=='A'){
			for(int k=0;k<i;k++){
				if((A[k].name).compareTo(nameToFind)==0)
					return true;
			}
		}
		else{
			for(int k=0;k<i;k++){
				if((B[k].name).compareTo(nameToFind)==0)
					return true;
			}
		}
		return false;
	}

	public static void inputHero(char user){
		char type;
		System.out.println("Input Player : "+user+"'s Heroes : \n");
		for(i=0;i<5;i++){
			input = in.nextLine();
			while(checkName(input,user)){
				System.out.println("Name already exists! Please re-enter : ");
				input = in.nextLine();
			}
			t = input.charAt(0);
			Coordinate c = new Coordinate();
			if(user=='A'){
				c.x = 4;
				c.y = i;
				if(t=='P'){
	                A[i] = new Pawn(input,user,c,true);
	                board[4][i] = A[i].player+"-"+A[i].name;
	            } 
	            else if(t=='G'){
	                A[i] = new Giant(input,user,c,true);
	                board[4][i] = A[i].player+"-"+A[i].name;
	            }
	            else{
	                A[i] = new Wizard(input,user,c,true);
	                board[4][i] = A[i].player+"-"+A[i].name;
	            }
			}
			else{
				c.x = 0;
            	c.y = 4-i;
            	if(t=='P'){
	                B[i] = new Pawn(input,user,c,true);
	                board[0][4-i] = B[i].player+"-"+B[i].name;
	            }
	            else if(t=='G'){
	                B[i] = new Giant(input,user,c,true);
	                board[0][4-i] = B[i].player+"-"+B[i].name;
	            }
	            else{
	                B[i] = new Wizard(input,user,c,true);
	                board[0][4-i] = B[i].player+"-"+B[i].name;
	            }
			}
		}
	}

}