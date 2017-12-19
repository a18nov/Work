import java.util.*;
public class GameBoard{
	
	static String board[][] = new String[5][5];
	static int scoreA=0,scoreB=0,i=0,j=0;
	static Hero[] A = new Hero[5];
	static Hero[] B = new Hero[5];
	static int flag=0;
	static Scanner in = new Scanner(System.in);
	static String input;
	static char ch;

	public static void main(String[] args) {
		Coordinate cor = new Coordinate();
		

		for(i=0;i<5;i++)
			for(j=0;j<5;j++)
				board[i][j]="-";

		playerInput('A');
		playerInput('B');
		displayScore();
		System.out.println("\nGame Commences!\n");

		while(scoreA<5&&scoreB<5){
			while(scoreA<5){
				System.out.println("Enter Hero to move for A : ");
				input = in.nextLine();
				cor = searchHero(input,'A');
				if(cor.x==-1){
					System.out.println("Error : Hero not found!");
				}
				else{
					Hero H = getHero(cor,'A');
					System.out.println(H.getType()+" is at"+" x:"+(cor.x+1)+
						",y:"+(cor.y+1));
					System.out.println("Enter move : ");
					input = in.nextLine();
					ch = input.charAt(0);
					switch(ch){
						case 'F':{

							break;
						}
					}
					//Collision

					//Out of Board
					//hit and update
				}
			}
			
		}

		

	}


	public static void playerInput(char X){
		char t;
	    System.out.print("Input Player "+X+"'s Heroes : \n");
		for(i=0;i<5;i++){
            input = in.nextLine();
            t = input.charAt(0);
            if(t=='P'&&X=='A'){
                A[i] = new Pawn('A',input,4,i,true);
                board[4][i] = A[i].player+"-"+A[i].name;
            }
            else if(t=='T'&&X=='A'){
                A[i] = new Troll('A',input,4,i,true);
                board[4][i] = A[i].player+"-"+A[i].name;
            }
            else if(t=='K'&&X=='A'){
                A[i] = new Knight('A',input,4,i,true);
                board[4][i] = A[i].player+"-"+A[i].name;
            }
            else if(t=='P'&&X=='B'){
                B[i] = new Pawn('B',input,0,i,true);
                board[0][i] = B[i].player+"-"+B[i].name;
            }
            else if(t=='T'&&X=='B'){
                B[i] = new Troll('B',input,0,i,true);
                board[0][i] = B[i].player+"-"+B[i].name;
            }
            else{
                B[i] = new Knight('B',input,0,i,true);
                board[0][i] = B[i].player+"-"+B[i].name;
            }
        }
        displayBoard();
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
		System.out.println("\nScore of A : "+scoreA+"\nScore of B : "+scoreB);
	}
	public static Coordinate searchHero(String toFind,char player){
		Coordinate negative = new Coordinate();
		negative.x = -1;
		negative.y = -1;
		if(player=='A'){
			for(i=0;i<5;i++) {
				if((A[i].name).compareTo(toFind)==0){
					return A[i].coordinate;
				}
			}
		}
		else{
			for(i=0;i<5;i++) {
				if((B[i].name).compareTo(toFind)==0){
					return B[i].coordinate;
				}
			}
		}
		return negative;
	}
	public static Hero getHero(Coordinate coordinate,char player){
		if(player=='A'){
			for(i=0;i<5;i++) {
				if(board[coordinate.x][coordinate.y].compareTo("A-"+A[i].name)==0)
					return A[i];
			}
		}
		else{
			for(i=0;i<5;i++) {
				if(board[coordinate.x][coordinate.y].compareTo("B-"+B[i].name)==0)
					return B[i];
			}
		}
		return A[0];
	}
}
