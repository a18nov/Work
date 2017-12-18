public class Knight extends Hero
{
    int step = 2;
    public Knight(char P,String n,int x,int y,boolean s){
        super(P,n,x,y,s);
    }
    int getStep(){
        return step;
    }
}
