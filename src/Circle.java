// Author: Cori Nicole Bradshaw
// Class: Circle
// This class inherits from class Shape and constructs a circle (using a view object) depending on the user specified requirements. 
// It also calculates the area of the circle along with the perimeter. 
// This class contains 3 fields, 1 constructor, and 4 methods.

public class Circle extends Shape{
private double area;
private double perimeter;
private double radius;


    public void Circle( Radius theRadius){
      super.Shape();
      radius = theRadius.setRadius();
    }

    public double calculateArea(Radius newRadius, Base newBase, Height newHeight){
       area = Math.PI * radius* radius;
       area = (double)Math.round(area * 100) / 100;
      return area;
    }

    public double calculatePerimeter(Radius newRadius, Base newBase, Height newHeight) {

        perimeter = 2 * Math.PI * radius;
        perimeter = (double)Math.round(perimeter * 100) / 100;
                return perimeter;

   
    }

    public void draw(int x, int y, Base newBase, Height newHeight, Radius newRadius, double area, double perimeter){
    View gui = new View();

  
    gui.infoFrame(x,y,newBase.setBase(),newHeight.setHeight(),radius,area, perimeter);

    
    
    }


    public String toString(){
    return super.toString()+"    Radius: "+radius + "    Area: " + area+ "    Perimeter: "+perimeter;

    }
}
