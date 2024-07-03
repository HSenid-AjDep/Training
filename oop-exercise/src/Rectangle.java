public class Rectangle {
    double length ;
    double width ;

    public Rectangle (double length,double width){
        this.length=length;
        this.width=width;
    }
    public double calculatedArea(){
        return length*width;
    }
}