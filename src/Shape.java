// Author: Cori Nicole Bradshaw
// Class: Shape
// Shape is an abstract class - meaning this class can not be instantiated. It can only be used by subclasses. 
// Abstract classes: 1. Define methods which can be used by the inheriting subclass.
//				     2. Define abstract methods which the inheriting subclass must implement.
//					 3. Provide a common interface which allows the subclass to be interchanged with all other subclasses.

public abstract class Shape{
    private int xValue, yValue;


    public void Shape(){
        xValue = 0;
        yValue =0;


    }
    public void getxValue(int newxValue){
        xValue = newxValue;
    }
    public void getyValue(int newyValue){
        yValue = newyValue;
    }
    public int setxValue(){
        return xValue;
    }
    public int setyValue(){
        return yValue;
    }
    public abstract double calculateArea(Radius newRadius, Base newBase,Height newHeight);
    
    public abstract double calculatePerimeter(Radius newRadius, Base newBase, Height newHeight);

    public abstract void draw(int x, int y, Base newBase, Height newHeight, Radius newRadius, double area, double perimeter);

    public String toString(){
        return " \n X Coordinate: "+xValue+"   Y Coordinate: "+yValue;
    }
}
