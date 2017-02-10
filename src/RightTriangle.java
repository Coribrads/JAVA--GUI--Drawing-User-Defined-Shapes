// Author: Cori Nicole Bradshaw
// Class: RightTriangle
// This class extends class Shape and calculates the area and perimeter of the user specified demensions. 
// This class also uses a Class View Object which sends the information to the gui. 
// This class contains 4 fields, 1 constructor, and 4 methods. 

public class RightTriangle extends Shape{
    private double area;
    private double perimeter;
    private double base;
    private double height;

    public void RightTriangle(Base theBase, Height theHeight){
        super.Shape();
        base = theBase.setBase();
        height = theHeight.setHeight();
    }

 
    public double calculateArea(Radius newRadius, Base newBase, Height newHeight){
        area = (base*height)/2;
        area = (double)Math.round(area * 100) / 100;
        return area;

    }

    public double calculatePerimeter(Radius newRadius, Base newBase, Height newHeight){
        perimeter = base+ height + Math.sqrt((base*base)+(height*height));
        perimeter = (double)Math.round(perimeter * 100) / 100;
        return perimeter;

    }

    public void draw(int x, int y, Base newBase, Height newHeight, Radius newRadius, double area, double perimeter){
        View gui = new View(); // create an object to invoke the drawFrame in View
        gui.infoFrame(x,y,base,height,newRadius.setRadius(),area, perimeter);
  }

    public String toString(){
        return super.toString() + "    Base: "+base +"    Height: "+height+ "    Area: " + area+ "    Perimeter: "+perimeter;
    }
}