package practica1;


/**
 * class FiguresGroup.
 * 
 * @author LTP 
 * @version 2020-21
 */

public class FiguresGroup {
    private static final int NUM_FIGURES = 10;
    private Figure[] figuresList = new Figure[NUM_FIGURES];
    private int numF = 0;
    
    public void add(Figure f) { 
        if(!this.found(f)) {
            figuresList[numF++] = f; 
        }
    
    }
    
    public double area() {
        double suma = 0;
        for (int i = 0; i < numF; i++) {
            suma += figuresList[i].area();
        }
        return suma;
    }
    
    public Figure greatestFigure() { //devuelva la figura del grupo cuya área sea mayor. D
         if(numF != 0) {
            Figure res = figuresList[0];
            for(int i = 1; i < numF; i++){
                if(figuresList[i].area() > res.area()){
                    res = figuresList[i];
                }
            }
            return res;
        }
        return null;
    }
    
    
    
    public String toString() {
        String s = "";
        for (int i = 0; i < numF; i++) {
            s += "\n" + figuresList[i];
        }
        return s;
    }

    private boolean found(Figure f) {
        for (int i = 0; i < numF; i++) {
            if (figuresList[i].equals(f)) return true;
        }
        return false;
    }

    private boolean included(FiguresGroup g) {
        for (int i = 0; i < g.numF; i++) {
            if (!found(g.figuresList[i])) return false;
        }
        return true;
    }
    
    public boolean equals (Object o) {
        
        if (!(o instanceof FiguresGroup)) { return false; }
        FiguresGroup fg = (FiguresGroup) o;
        return this.included(fg) && fg.included(this);
    
    }
    
}