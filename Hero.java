public class Hero
{
    char player;
    String name;
    Coordinate coordinate = new Coordinate();
    boolean status;
    public Hero(char P,String n,int x,int y,boolean s){
        player = P;
        name = n;
        coordinate.x = x;
        coordinate.y = y;
        s = status;
    }
}
