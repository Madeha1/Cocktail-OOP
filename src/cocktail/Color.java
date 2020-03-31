package cocktail;

public class Color implements GetInfo{
   
    private int R ;
    private int G;
    private int B;

    public Color (){}
    public Color(int r , int g ,int b)
    {
        R =r;
        G = g;
        B = b;
    }
    public void setB(int b) {
        B = b;
    }

    public void setG(int g) {
        G = g;
    }

    public void setR(int r) {
        R = r;
    }

    public int getB() {
        return B;
    }

    public int getG() {
        return G;
    }

    public int getR() {
        return R;
    }

    @Override
    public String getInfo()
    {
         return "the rgb color is : "+ this.R +","+this.G+","+this.B+"\n";
    }
    
}
