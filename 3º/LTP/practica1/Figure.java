package practica1;


/**
 * class Figure.
 * 
 * @author LTP 
 * @version 2020-21
 */

public abstract class Figure {
    protected double x;
    protected double y;
    
    public Figure(double x, double y) {
        this.x = x; 
        this.y = y; 
    }
    
    public abstract double area();
    
    public abstract double perimeter();
    
    public boolean equals(Object o) {
        if (!(o instanceof Figure)) { return false; }
        Figure f = (Figure) o;
        return x == f.x && y == f.y;
    }
    
    public String toString() {
        return "Position: (" + x + ", " + y + ")"; 
    }
}