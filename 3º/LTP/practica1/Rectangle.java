package practica1;


/**
 * Write a description of class Rectangle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rectangle extends Figure {
    private double base;
    private double height;
    

     
    public boolean equals(Object o){
        if (!(o instanceof Rectangle)) { return false; }
        Rectangle t = (Rectangle) o;
        return super.equals(o) && this.base == t.base && this.height == t.height;
    }
                                    
    
    public Rectangle(double x, double y, double b, double h) {
        super(x, y);
        this.base = b;
        this.height = h;
    }

    public double area() {
        return this.base * this.height;
    }
    
    public double perimeter() {
        return 2 * (base + height);
    }
    
    public String toString() {
        return "Rectangle:\n\t" +
            super.toString() +
            "\n\tBase: " + base +
            "\n\tHeight: " + height;
    }
}
