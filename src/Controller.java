// Author: Cori Nicole Bradshaw
// Class: Controller
// This class implements the ActionListener interface. The controller receives/responds to the commands from the User. 
// This class contains 7 private objects and 1 static variable. 

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;



public class Controller implements ActionListener{

    
// Objects or Instance of Classes
private Radius r = new Radius();
private Rectangle r2 = new Rectangle();
private RightTriangle t = new RightTriangle();
private Circle c = new Circle();
private Base b = new Base();
private Height h = new Height();
private View v = new View();
static String shapeText = "null"; //communicate between view and controller

     public void actionPerformed(ActionEvent e) {
// getting the text from the textboxes
        String radText = View.radius.getText();
        String baseText = View.base.getText();
        String heightText = View.height.getText();
        String bordText = View.borderColor.getText();
        String fillText = View.fillColor.getText();
        String xText = View.xValue.getText();
        String yText = View.yValue.getText();
// try-catch action commands
            try{
               //Selecting a shape from the Menu
               if(e.getActionCommand().equals("Circle")){
                   shapeText = "Circle";
                }
               else if(e.getActionCommand().equals("Rectangle")){
                   shapeText = "Rectangle";
                }
               else if(e.getActionCommand().equals("Right Triangle")){
                    shapeText = "Right Triangle";
                }
             // When "Write to File" button is pressed:
             if(e.getActionCommand().equals("Write to File")){


                enterRadius(Double.parseDouble(radText));
                enterBaseHeight(Double.parseDouble(baseText),Double.parseDouble(heightText));
                enterXYValues(Integer.parseInt(xText), Integer.parseInt(yText));


                if(shapeText.equals("Circle")|| shapeText.equals("circle")||shapeText.equals("Rectangle")|| shapeText.equals("rectangle")||shapeText.equals("Right Triangle")|| shapeText.equals("triangle")|| shapeText.equals("right triangle")){
                selectShape(shapeText);
                                                }
                else System.out.println("PLEASE ENTER CIRCLE, RECTANGLE, OR RIGHT TRIANGLE");

                if(fillText.equals("Red")|| fillText.equals("red")||fillText.equals("Yellow")|| fillText.equals("yellow")||fillText.equals("Green")|| fillText.equals("green")||fillText.equals("Blue")|| fillText.equals("blue")){
                specifyFillColor(fillText);
                }
                else v.errorFrame("ENTER ONLY RED, BLUE, YELLOW, or GREEN FOR COLORS");
                if(bordText.equals("Red")||bordText.equals("red")||bordText.equals("Yellow")||bordText.equals("Yellow")||bordText.equals("Green")||bordText.equals("green")||bordText.equals("Blue")||bordText.equals("blue")){
                specifyBorderColor(bordText);
                }
                else v.errorFrame("ENTER ONLY RED, BLUE, YELLOW, or GREEN FOR COLORS");
                

       
                
                try {
                    writeToFile(shapeText, fillText, bordText);
                } catch (IOException ex) {
                    ex.getMessage();
                    System.out.println(ex);
                }
                }

             // When "DRAW" button is pressed:
             if(e.getActionCommand().equals("DRAW")){
                 
                enterRadius(Double.parseDouble(radText));
                enterBaseHeight(Double.parseDouble(baseText),Double.parseDouble(heightText));
                enterXYValues(Integer.parseInt(xText), Integer.parseInt(yText));

               if(shapeText.equals("Circle")|| shapeText.equals("circle"))
                {
                                        selectShape("Circle");
                                        c.draw(c.setxValue(), c.setyValue(), b, h, r, c.calculateArea( r, b, h), c.calculatePerimeter(r,b,h));
                                        
                }
                else if (shapeText.equals("Rectangle") || shapeText.equals("rectangle")) {
                                       selectShape("Rectangle");
                                       r2.draw(r2.setxValue(), r2.setyValue(), b, h, r, r2.calculateArea(r, b, h), r2.calculatePerimeter(r, b, h));
                }
                 else if(shapeText.equals("Right Triangle") || shapeText.equals("triangle") || shapeText.equals("right triangle"))
                 {
                                        selectShape("Right Triangle");
                                        t.draw(t.setxValue(), t.setyValue(), b, h , r, t.calculateArea(r,b,h), t.calculatePerimeter(r,b,h));
                }
                else v.errorFrame("PLEASE ENTER CIRCLE, RECTANGLE, OR RIGHT TRIANGLE");


                if(fillText.equals("Red")|| fillText.equals("red")||fillText.equals("Yellow")|| fillText.equals("yellow")||fillText.equals("Green")|| fillText.equals("green")||fillText.equals("Blue")|| fillText.equals("blue")){
                specifyFillColor(fillText);
                }
                else v.errorFrame("ENTER ONLY RED, BLUE, YELLOW, or GREEN FOR COLORS");
                if(bordText.equals("Red")||bordText.equals("red")||bordText.equals("Yellow")||bordText.equals("Yellow")||bordText.equals("Green")||bordText.equals("green")||bordText.equals("Blue")||bordText.equals("blue")){
                specifyBorderColor(bordText);
                }
                else v.errorFrame("ENTER ONLY RED, BLUE, YELLOW, or GREEN FOR COLORS");
                }


            }
            catch(NumberFormatException a){     // catch if the number entered is not a number
             a.getMessage();
             v.errorFrame("ENTER NUMBERS FOR RADIUS, BASE, HEIGHT, X, and Y");
            }
       }

public void selectShape(String n){
// Selected from Menu - Implemented in actionPerformed
    // Let's go ahead and write to the screen

System.out.print("\nShape Selected: "+n);
}
public void specifyFillColor(String n){
// Selected from Menu - Implemented in actionPerformed
    // Let's go ahead and write to the screen

System.out.print("         Fill Color Selected: "+n);
}
public void specifyBorderColor(String n){
// Selected from Menu - Implemented in actionPerformed
    // Let's go ahead and write to the screen

System.out.println("        Border Color Selected: "+n);
}
public void enterRadius(double rads){
// Entered into TextBox - object holds radius
    r.getRadius(rads);
    c.Circle(r);
}
public void enterBaseHeight(double userBase, double userHeight){
// Entered into TextBox - objects holds base and height
    b.getBase(userBase);
    h.getHeight(userHeight);
    r2.Rectangle(b, h);
    t.RightTriangle(b, h);
   
}
public void enterXYValues(int userX , int userY){
    //Shape is abstract and initialization of a Shape object is illegal.....
    c.getxValue(userX); c.getyValue(userY);
    r2.getxValue(userX); r2.getyValue(userY);
    t.getxValue(userX); t.getyValue(userY);
    c.setxValue(); c.setyValue();
    r2.setxValue(); r2.setyValue();
    t.setxValue(); t.setyValue();
 
}
public void writeToDisplay(){
// Implemented through actionPerformed
}
public void writeToFile(String userShape, String userFill, String userBord) throws IOException{

    try{
        FileWriter writeText = new FileWriter("Programming Assignment 2 Output.txt", true);
        BufferedWriter out = new BufferedWriter(writeText);
        if (userShape.equals("Circle")|| userShape.equals("circle")){
            c.calculateArea(r, b, h);
            c.calculatePerimeter(r, b, h);
            out.write("\n\n  Shape: " + userShape + "   Fill Color: "+ userFill + "    Border Color: "+ userBord+ "\n " + c.toString());

        }
        if (userShape.equals("Rectangle")|| userShape.equals("rectangle")){
            r2.calculateArea(r, b, h);
            r2.calculatePerimeter(r, b, h);
            out.write("\n\n  Shape: " + userShape + "   Fill Color: "+ userFill + "    Border Color: "+ userBord+ "\n " + r2.toString());
        }
        if (userShape.equals("Right Triangle")|| userShape.equals("right triangle")|| userShape.equals("triangle")){
            t.calculateArea(r, b, h);
            t.calculatePerimeter(r, b, h);
            out.write("\n\n  Shape: " + userShape + "   Fill Color: "+ userFill + "    Border Color: "+ userBord+ "\n " + t.toString());
        }
     out.close();
    }
    catch (IOException exc){
        exc.getMessage();
        v.errorFrame("The file can not be created. Please try again. ");
       System.out.println("\nThe file can not be created.");
       System.out.println("Please enter words in the text boxes");
        
    }
}
}
    
     


     


