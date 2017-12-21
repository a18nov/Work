import java.util.Scanner;
public class Game
{
    static String board[][] = new String[5][5];
    static int scoreA = 0;
    static int scoreB = 0;
    
    
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        
        //Hero Arrays for both Players
        Hero[] A = new Hero[5];
        Hero[] B = new Hero[5];
        //Variable init
        int i,j,x,y,n;
        String input,name;
        char t,move;
        //Initialise Board with "-"
        for(i=0;i<5;i++){
            for(j=0;j<5;j++){
                board[j][i] = "-";
            }      
        }
        
        //Player A Input
        System.out.println("Player A input : ");
        for(i=0;i<5;i++){
            input = in.nextLine();
            t = input.charAt(0);
            if(t=='P'){
                A[i] = new Pawn('A',input,4,i,true);
            }
            else if(t=='T'){
                A[i] = new Troll('A',input,4,i,true);
            }
            else{
                A[i] = new Knight('A',input,4,i,true);
            }
            board[4][i] = A[i].player+"-"+A[i].name;
        }
        displayBoard();
        
        //Player B Input
        System.out.println("Player B input : ");
        for(i=0;i<5;i++){
            input = in.nextLine();
            t = input.charAt(0);
            if(t=='P'){
                B[i] = new Pawn('B',input,0,i,true);
            }
            else if(t=='T'){
                B[i] = new Troll('B',input,0,i,true);
            }
            else{
                B[i] = new Knight('B',input,0,i,true);
            }
            board[0][i] = B[i].player+"-"+B[i].name;
        }
        displayBoard();
        displayScore();
        
        //Game start
        while(scoreA<5||scoreB<5){
            //Player A movement
            x=0;y=0;n=0;
            System.out.println("Player A Movement : \nEnter Hero name to move : ");
            name = in.nextLine();
            System.out.println("Enter move : ");
            move = in.nextLine().charAt(0);
            for(i=0;i<5;i++){
                if((A[i].name).compareToIgnoreCase(name)==0){
                    x=A[i].coordinate.x;
                    y=A[i].coordinate.y;
                    n=i;
                    break;
                }
            }
            switch(move){
                case 'F':{ //Forward function
                    if(x-1<0){
                        System.out.println("Out of Board!");
                        break;
                    }
                    if(board[x-1][y].compareTo("-")!=0){
                        if(board[x-1][y].charAt(0)=='A'){
                            System.out.println("Move not allowed : Own hero in the place!");
                            break;
                        }
                        else{
                            for(i=0;i<5;i++){
                                if(B[i].coordinate.x==x-1&&B[i].coordinate.y==y){
                                    scoreA++;
                                    B[i].status = false;
                                    board[x-1][y] = A[n].player+"-"+A[n].name;
                                    board[x][y] = "-";
                                    displayScore();
                                    displayBoard();
                                }
                            }
                        }
                    }
                    if(board[x-1][y].compareTo("-")==0){
                        board[x-1][y] = A[n].player+"-"+A[n].name;
                        board[x][y] = "-";
                        A[n].coordinate.x  = x-1;
                        displayBoard();
                    }
                    break;
                }
                case 'B':{ //Backward Function
                    if(x+1>=5){
                        System.out.println("Out of Board!");
                        break;
                    }
                    if(board[x+1][y].compareTo("-")!=0){
                        if(board[x+1][y].charAt(0)=='A'){
                            System.out.println("Move not allowed : Own hero in the place!");
                            break;
                        }
                        else{
                            for(i=0;i<5;i++){
                                if(B[i].coordinate.x==x+1&&B[i].coordinate.y==y){
                                    scoreA++;
                                    B[i].status = false;
                                    board[x+1][y] = A[n].player+"-"+A[n].name;
                                    board[x][y] = "-";
                                    displayScore();
                                    displayBoard();
                                }
                            }
                        }
                    }
                    if(board[x+1][y].compareTo("-")==0){
                        board[x+1][y] = A[n].player+"-"+A[n].name;
                        board[x][y] = "-";
                        A[n].coordinate.x  = x+1;
                        displayBoard();
                    }
                    break;
                }
                case 'L':{ //Left Function
                    if(y-1<0){
                        System.out.println("Out of Board!");
                        break;
                    }
                    if(board[x][y-1].compareTo("-")!=0){
                        if(board[x][y-1].charAt(0)=='A'){
                            System.out.println("Move not allowed : Own hero in the place!");
                            break;
                        }
                        else{
                            for(i=0;i<5;i++){
                                if(B[i].coordinate.x==x&&B[i].coordinate.y==y-1){
                                    scoreA++;
                                    B[i].status = false;
                                    board[x][y-1] = A[n].player+"-"+A[n].name;
                                    board[x][y] = "-";
                                    displayScore();
                                    displayBoard();
                                }
                            }
                        }
                    }
                    if(board[x][y-1].compareTo("-")==0){
                        board[x][y-1] = A[n].player+"-"+A[n].name;
                        board[x][y] = "-";
                        A[n].coordinate.y  = y-1;
                        displayBoard();
                    }
                    break;
                }
                case 'R':{  //Right Function
                    if(y+1>=5){
                        System.out.println("Out of Board!");
                        break;
                    }
                    if(board[x][y+1].compareTo("-")!=0){
                        if(board[x][y+1].charAt(0)=='A'){
                            System.out.println("Move not allowed : Own hero in the place!");
                            break;
                        }
                        else{
                            for(i=0;i<5;i++){
                                if(B[i].coordinate.x==x&&B[i].coordinate.y==y+1){
                                    scoreA++;
                                    B[i].status = false;
                                    board[x][y+1] = A[n].player+"-"+A[n].name;
                                    board[x][y] = "-";
                                    displayScore();
                                    displayBoard();
                                }
                            }
                        }
                    }
                    if(board[x][y+1].compareTo("-")==0){
                        board[x][y+1] = A[n].player+"-"+A[n].name;
                        board[x][y] = "-";
                        A[n].coordinate.y  = y+1;
                        displayBoard();
                    }
                    break;
                }
            }
            
            //Player 2 movement
            System.out.println("Player B Movement : \nEnter Hero name to move : ");
            name = in.nextLine();
            System.out.println("Enter move : ");
            move = in.nextLine().charAt(0);
            for(i=0;i<5;i++){
                if((B[i].name).compareToIgnoreCase(name)==0){
                    x=B[i].coordinate.x;
                    y=B[i].coordinate.y;
                    n=i;
                    break;
                }
            }
            switch(move){
                case 'B':{
                    if(x-1<0){
                        System.out.println("Out of Board!");
                        break;
                    }
                    if(board[x-1][y].compareTo("-")!=0){
                        if(board[x-1][y].charAt(0)=='B'){
                            System.out.println("Move not allowed : Own hero in the place!");
                            break;
                        }
                        else{
                            for(i=0;i<5;i++){
                                if(A[i].coordinate.x==x-1&&A[i].coordinate.y==y){
                                    scoreB++;
                                    A[i].status = false;
                                    board[x-1][y] = B[n].player+"-"+B[n].name;
                                    board[x][y] = "-";
                                    displayScore();
                                    displayBoard();
                                }
                            }
                        }
                    }
                    if(board[x-1][y].compareTo("-")==0){
                        board[x-1][y] = B[n].player+"-"+B[n].name;
                        board[x][y] = "-";
                        B[n].coordinate.x  = x-1;
                        displayBoard();
                    }
                    break;
                }
                case 'F':{
                    if(x+1>=5){
                        System.out.println("Out of Board!");
                        break;
                    }
                    if(board[x+1][y].compareTo("-")!=0){
                        if(board[x+1][y].charAt(0)=='B'){
                            System.out.println("Move not allowed : Own hero in the place!");
                            break;
                        }
                        else{
                            for(i=0;i<5;i++){
                                if(A[i].coordinate.x==x+1&&A[i].coordinate.y==y){
                                    scoreB++;
                                    A[i].status = false;
                                    board[x+1][y] = B[n].player+"-"+B[n].name;
                                    board[x][y] = "-";
                                    displayScore();
                                    displayBoard();
                                }
                            }
                        }
                    }
                    if(board[x+1][y].compareTo("-")==0){
                        board[x+1][y] = B[n].player+"-"+B[n].name;
                        board[x][y] = "-";
                        B[n].coordinate.x  = x+1;
                        displayBoard();
                    }
                    break;
                }
                case 'R':{
                    if(y-1<0){
                        System.out.println("Out of Board!");
                        break;
                    }
                    if(board[x][y-1].compareTo("-")!=0){
                        if(board[x][y-1].charAt(0)=='B'){
                            System.out.println("Move not allowed : Own hero in the place!");
                            break;
                        }
                        else{
                            for(i=0;i<5;i++){
                                if(A[i].coordinate.x==x&&A[i].coordinate.y==y-1){
                                    scoreB++;
                                    A[i].status = false;
                                    board[x][y-1] = B[n].player+"-"+B[n].name;
                                    board[x][y] = "-";
                                    displayScore();
                                    displayBoard();
                                }
                            }
                        }
                    }
                    if(board[x][y-1].compareTo("-")==0){
                        board[x][y-1] = B[n].player+"-"+B[n].name;
                        board[x][y] = "-";
                        B[n].coordinate.y  = y-1;
                        displayBoard();
                    }
                    break;
                }
                case 'L':{
                    if(y+1>=5){
                        System.out.println("Out of Board!");
                        break;
                    }
                    if(board[x][y+1].compareTo("-")!=0){
                        if(board[x][y+1].charAt(0)=='B'){
                            System.out.println("Move not allowed : Own hero in the place!");
                            break;
                        }
                        else{
                            for(i=0;i<5;i++){
                                if(A[i].coordinate.x==x&&A[i].coordinate.y==y+1){
                                    scoreA++;
                                    A[i].status = false;
                                    board[x][y+1] = B[n].player+"-"+B[n].name;
                                    board[x][y] = "-";
                                    displayScore();
                                    displayBoard();
                                }
                            }
                        }
                    }
                    if(board[x][y+1].compareTo("-")==0){
                        board[x][y+1] = B[n].player+"-"+B[n].name;
                        board[x][y] = "-";
                        B[n].coordinate.y  = y+1;
                        displayBoard();
                    }
                    break;
                }
            }
        }
        
        
    }
    
    public static void displayBoard(){
        int i,j;
        for(i=0;i<5;i++){
            for(j=0;j<5;j++){
                System.out.print(board[i][j]+"\t");
            }
            System.out.println();
        }
    }
    
    public static void displayScore(){
        System.out.println("\nScore of A : "+scoreA+"\nScore of B : "+scoreB+"\n");
    }
}
//comment