package practica1;


/**
 * class Circle.
 * 
 * @author LTP 
 * @version 2020-21
 */

public class Circle extends Figure {
    private double radius;
    
    
    public boolean equals(Object o) {
        if (!(o instanceof Circle)) { return false; } //instanceof permite averiguar si un objeto es 
        Circle c = (Circle) o;                          //instancia de una determinada clase. En este caso Circle
        return super.equals(o) && this.radius == c.radius;
    
    }
    
    
    public Circle(double x, double y, double r) { //constructor
        super(x, y); //uper se utiliza para referirse a elementos de la clase padre.
                        //En este caso al constructor de la superclase.
        radius = r;
    }

    public double perimeter(){ return 2 * Math.PI * radius; }
    
    public double area() {
        return Math.PI * Math.pow(radius, 2); //radius elevado a 2
        //return Math.PI * radius * radius
    }
    
    
    
    public String toString() {
        return "Circle:\n\t" +
            super.toString() +
            "\n\tRadius: " + radius;
    }
}