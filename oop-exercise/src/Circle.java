public class Circle {
    double radius ;

    public Circle (double radius){
        this.radius=radius;
    }
    public double calculatedArea(){
        return Math.PI*radius*radius;
    }
}
