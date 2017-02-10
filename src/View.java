// Author: Cori Nicole Bradshaw
// Class: View
// This class inherits from the class JFrame which allows gui creation. 
// This class also imports from Swing and Awt which allows graphic creation. 
// Lastly, this class uses override inside of an innerclass: paintPanel() to allow a user specified object to be painted/created. 

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;



public class View extends JFrame{
// To create the graphic, I need to use View and create on view. Need these variables from controller and classes.
private int guix, guiy;
private double guiradius, guibase, guiheight;
// To get the text from the GUI into the controller (action listener), make textboxes static
static JTextField radius, base, height, shape, fillColor, borderColor, xValue, yValue; // to get Text from GUI


    public void MainFrame(){
        System.out.println("\t\t\tWelcome. Let's Draw Some Shapes. \n");

        //Default GUI Set Up
        setTitle("SHAPE DRAWER");
        setSize(1000,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //Center(Information Labels) Panel - Center
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setBackground(Color.LIGHT_GRAY);
        add(centerPanel, BorderLayout.CENTER);
        centerPanel.setVisible(true);
        centerPanel.setLayout(new GridLayout(6, 1));
        JLabel centerLabel = new JLabel("                                                                                                                             Welcome. Let's Draw Some Shapes ");
        JLabel centerLabel2 = new JLabel("                                                                                                1. Enter in a Shape.  Options:  Circle, Rectangle, or Right Triangle ");
        JLabel centerLabel3 = new JLabel("                                                                                                2. Enter in a Fill Color for the Shape.  Options:  Red, Yellow, Green, or Blue");
        JLabel centerLabel4 = new JLabel("                                                                                                3. Enter in a Border Color for the Shape.  Options:  Red, Yellow, Green, or Blue");
        JLabel centerLabel5 = new JLabel("                                                                                                4. Enter in Radius, Base, and Height values");
        JLabel centerLabel6 = new JLabel("                                                                                                5. Enter in X and Y values. (These will indicate where the drawing begins) ");
        centerPanel.add(centerLabel);
        centerPanel.add(centerLabel2);
        centerPanel.add(centerLabel3);
        centerPanel.add(centerLabel4);
        centerPanel.add(centerLabel5);
        centerPanel.add(centerLabel6);


        //East(Buttons) Panel - East
        JPanel EastPanel = new JPanel();
        EastPanel.setBackground(Color.LIGHT_GRAY);
        add(EastPanel, BorderLayout.EAST);
        EastPanel.setVisible(true);

        //UserValue(TextBox) Panel - South
       JPanel userValuePanel = new JPanel();
       add(userValuePanel, BorderLayout.SOUTH);


        //MenuBar(Menu) Panel - North
        JPanel menuBar = new JPanel();
        add(menuBar, BorderLayout.NORTH);
        menuBar.setVisible(true);

        // SETTING UP THE MENU
        JMenuBar menuBar2 = new JMenuBar();
        add(menuBar2, BorderLayout.WEST);
        JMenu shapeButton = new JMenu("Shape");
        JMenuItem circlebutton = new JMenuItem("Circle");
        JMenuItem rectanglebutton = new JMenuItem("Rectangle");
        JMenuItem trianglebutton = new JMenuItem("Right Triangle");
        shapeButton.add(circlebutton);
        shapeButton.add(rectanglebutton);
        shapeButton.add(trianglebutton);
        menuBar2.add(shapeButton);
        shapeButton.setVisible(true);
        shapeButton.addActionListener(new Controller());
        circlebutton.setVisible(true);
        circlebutton.addActionListener(new Controller());
        rectanglebutton.addActionListener(new Controller());
        trianglebutton.addActionListener(new Controller());
        setJMenuBar(menuBar2);
        System.out.println("\tPlease Select a Shape From the GUI Menu \"SHAPE\"");
        System.out.println("\tAvailable Options Include: Circle, Rectangle, or Right Triangle\n");
            //Create Fill Color TextBox
        JLabel fillColorLabel = new JLabel("Fill Color: ");
        fillColor = new JTextField(10);
        fillColor.addActionListener(new Controller());
        menuBar.add(fillColorLabel);
        menuBar.add(fillColor);
            //Create Border Color TextBox
        JLabel borderColorLabel = new JLabel("BorderColor: ");
        borderColor = new JTextField(10);
        borderColor.addActionListener(new Controller());
        menuBar.add(borderColorLabel);
        menuBar.add(borderColor);
        System.out.println("\tEnter a Fill Color for the Shape in the GUI Text Box \"COLOR\"");
        System.out.println("\tAlso Enter a Border Color for the Shape in the GUI Text Box \"COLOR\"");
        System.out.println("\tAvailable Options Include: Red, Yellow, Green, or Blue\n");


       //USERVALUEPANEL (TEXT BOXES) _ SOUTH
            //Crete TextBox for Radius
       radius = new JTextField(5);
       JLabel radiuslabel = new JLabel("Radius: ");
       radius.addActionListener(new Controller());
       userValuePanel.add(radiuslabel);
       userValuePanel.add(radius);
       System.out.println("\tEnter a Radius in the GUI Text Box Labled \"RADIUS\" IFF the Shape Selected is a Circle.");
            // Create TextBox for Base
      base = new JTextField(5);
      base.addActionListener(new Controller());
      JLabel baseLabel = new JLabel("Base: ");
      userValuePanel.add(baseLabel);
      userValuePanel.add(base);
            // Create TextBox for Height
      height = new JTextField(5);
      JLabel heightLabel = new JLabel("Height: ");
      userValuePanel.add(heightLabel);
      height.addActionListener(new Controller());
      userValuePanel.add(height);
      System.out.println("\tEnter a Base and a Height in the GUI Text Boexes Labeled \"BASE\" and \"HEIGHT\" IFF the Shape Selected is a Rectangle or a Right Triangle.\n");
            // Create TextBox for X & Y Coordinates
      JLabel xLabel = new JLabel("X: ");
      xValue = new JTextField(5);
      xValue.addActionListener(new Controller());
      JLabel yLabel = new JLabel("Y: ");
      yValue = new JTextField(5);
      yValue.addActionListener(new Controller());
      userValuePanel.add(xLabel);
      userValuePanel.add(xValue);
      userValuePanel.add(yLabel);
      userValuePanel.add(yValue);
      System.out.println("\tEnter X and Y Coordinates in the GUI Text Boxes Labeled \"X\" and \"Y\". (Rec X: 0 Y: 350 for left; Circle )");



      //EASTPANEL (BUTTONS) _ EAST
      EastPanel.setLayout(new GridLayout(2,1));
      JButton fileButton = new JButton("Write to File");
      fileButton.addActionListener(new Controller());
      JButton Draw = new JButton("DRAW");
      Draw.addActionListener(new Controller());
      EastPanel.add(Draw);
      EastPanel.add(fileButton);


    }
    public void errorFrame(String message){
        //Create a New JFrame for ERROR messages
        JFrame errorFrame = new JFrame("ERROR");
        errorFrame.setSize(1000, 100);
        errorFrame.setLayout(new BorderLayout());
        JPanel centerPanel = new JPanel();
        errorFrame.add(centerPanel, BorderLayout.CENTER);
        JLabel errorLabel = new JLabel(message);
        centerPanel.add(errorLabel);
        errorFrame.setVisible(true);
    }

    public void infoFrame(int x, int y, double base, double height, double radius, double area, double perimeter){
        // Create a New JFrame to Draw
        paintPanel paint = new paintPanel();
        JFrame infoFrame = new JFrame();
        
        JPanel drawLabelSouth = new JPanel();
        JPanel drawLabelNorth = new JPanel();
        drawLabelSouth.setBackground(Color.WHITE);
        drawLabelNorth.setBackground(Color.WHITE);
        drawLabelSouth.setVisible(true);
        drawLabelNorth.setVisible(true);

        guix = x; guiy = y; guiradius = radius; guiheight = height; guibase = base;

        infoFrame.setTitle("DRAW SCREEN");
        infoFrame.setSize(500,500);
        infoFrame.setLayout(new BorderLayout());
        infoFrame.setVisible(true);

        paint.setBackground(Color.WHITE);
        infoFrame.add(paint, BorderLayout.CENTER);
        infoFrame.add(drawLabelSouth, BorderLayout.SOUTH);
        infoFrame.add(drawLabelNorth, BorderLayout.NORTH);

        JLabel infoLabel = new JLabel(" The shape is located at coordinates   X , Y :     ( "+x+","+y+" )");
        JLabel infoLabel2 = new JLabel("   Radius: "+radius+"    Base: "+base+"    Height: "+height+"    Area: "+area+"    Perimeter: "+perimeter);
        drawLabelNorth.add(infoLabel);
        drawLabelSouth.add(infoLabel2);

    }
// USE OF AN INNER CLASS TO PAINT GRAPHICS
    public class paintPanel extends JPanel{

        paintPanel(){
            setPreferredSize(new Dimension(1000,500));
        }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

    if(Controller.shapeText.equals("Circle") || Controller.shapeText.equals("circle")){

            if(fillColor.getText().equals("Red")|| fillColor.getText().equals("red")){
                     g.setColor(Color.RED);
                     g.fillOval(guix, guiy, (int)guiradius, (int)guiradius);              }
            if(fillColor.getText().equals("Yellow")|| fillColor.getText().equals("yellow")){
                     g.setColor(Color.YELLOW);
                     g.fillOval(guix, guiy, (int)guiradius, (int)guiradius);
            }
            if(fillColor.getText().equals("Green")|| fillColor.getText().equals("green")){
                     g.setColor(Color.GREEN);
                     g.fillOval(guix, guiy, (int)guiradius, (int)guiradius);
            }
            if(fillColor.getText().equals("Blue")|| fillColor.getText().equals("blue")){
                     g.setColor(Color.BLUE);
                     g.fillOval(guix, guiy, (int)guiradius, (int)guiradius);
            }
            if(borderColor.getText().equals("Red")|| borderColor.getText().equals("red")){
                     g.setColor(Color.RED);
                     g.drawOval(guix, guiy, (int)guiradius, (int)guiradius);              }
            if(borderColor.getText().equals("Yellow")|| borderColor.getText().equals("yellow")){
                     g.setColor(Color.YELLOW);
                     g.drawOval(guix, guiy, (int)guiradius, (int)guiradius);
            }
            if(borderColor.getText().equals("Green")|| borderColor.getText().equals("green")){
                     g.setColor(Color.GREEN);
                     g.drawOval(guix, guiy, (int)guiradius, (int)guiradius);
            }
            if(borderColor.getText().equals("Blue")|| borderColor.getText().equals("blue")){
                     g.setColor(Color.BLUE);
                     g.drawOval(guix, guiy, (int)guiradius, (int)guiradius);
            }

    }
  if(Controller.shapeText.equals("Right Triangle") || Controller.shapeText.equals("right triangle")|| Controller.shapeText.equals("triangle")){
                     int[] x = new int[]{guix ,guix,  guix+(int)guibase};
                     int[] y = new int[]{guiy - (int)guiheight ,guiy,  guiy };

            if(fillColor.getText().equals("Red")|| fillColor.getText().equals("red")){
                     g.setColor(Color.RED);
                     g.fillPolygon(x,y,3);
            }
            if(fillColor.getText().equals("Yellow")|| fillColor.getText().equals("yellow")){
                     g.setColor(Color.YELLOW);
                     g.fillPolygon(x,y,3);
            }
            if(fillColor.getText().equals("Green")|| fillColor.getText().equals("green")){
                     g.setColor(Color.GREEN);
                     g.fillPolygon(x,y,3);
            }
            if(fillColor.getText().equals("Blue")|| fillColor.getText().equals("blue")){
                     g.setColor(Color.BLUE);
                    g.fillPolygon(x,y,3);
            }
            if(borderColor.getText().equals("Red")|| borderColor.getText().equals("red")){
                     g.setColor(Color.RED);
                    g.drawPolygon(x,y,3);              }
            if(borderColor.getText().equals("Yellow")|| borderColor.getText().equals("yellow")){
                     g.setColor(Color.YELLOW);
                    g.drawPolygon(x,y,3);
            }
            if(borderColor.getText().equals("Green")|| borderColor.getText().equals("green")){
                     g.setColor(Color.GREEN);
                     g.drawPolygon(x,y,3);
            }
            if(borderColor.getText().equals("Blue")|| borderColor.getText().equals("blue")){
                     g.setColor(Color.BLUE);
                    g.drawPolygon(x,y,3);
            }
        }

 if(Controller.shapeText.equals("Rectangle") || Controller.shapeText.equals("rectangle")){

            if(fillColor.getText().equals("Red")|| fillColor.getText().equals("red")){
                     g.setColor(Color.RED);
                     g.fillRect(guix, guiy, (int)guibase, (int)guiheight);              }
            if(fillColor.getText().equals("Yellow")|| fillColor.getText().equals("yellow")){
                     g.setColor(Color.YELLOW);
                     g.fillRect(guix, guiy, (int)guibase, (int)guiheight);
            }
            if(fillColor.getText().equals("Green")|| fillColor.getText().equals("green")){
                     g.setColor(Color.GREEN);
                     g.fillRect(guix, guiy, (int)guibase, (int)guiheight);
            }
            if(fillColor.getText().equals("Blue")|| fillColor.getText().equals("blue")){
                     g.setColor(Color.BLUE);
                     g.fillRect(guix, guiy, (int)guibase, (int)guiheight);
            }
            if(borderColor.getText().equals("Red")|| borderColor.getText().equals("red")){
                     g.setColor(Color.RED);
                     g.drawRect(guix, guiy, (int)guibase, (int)guiheight);              }
            if(borderColor.getText().equals("Yellow")|| borderColor.getText().equals("yellow")){
                     g.setColor(Color.YELLOW);
                     g.drawRect(guix, guiy, (int)guibase, (int)guiheight);
            }
            if(borderColor.getText().equals("Green")|| borderColor.getText().equals("green")){
                     g.setColor(Color.GREEN);
                     g.drawRect(guix, guiy, (int)guibase, (int)guiheight);
            }
            if(borderColor.getText().equals("Blue")|| borderColor.getText().equals("blue")){
                     g.setColor(Color.BLUE);
                     g.drawRect(guix, guiy, (int)guibase, (int)guiheight);
            }
}

    }
    }
}





    
