public class Pawn extends Hero
{
    int step = 1;
    public Pawn(char P,String n,int x,int y,boolean s){
        super(P,n,x,y,s);
    }
    int getStep(){
        return step;
    }
    
}
