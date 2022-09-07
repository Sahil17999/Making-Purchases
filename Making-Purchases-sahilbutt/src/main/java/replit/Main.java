/**
  Write your header information here.
  Name: Sahil Butt
  Description of program: The following user will have the ability to choose the number of slices they want to buy. There are 5 different pizza styles to choose from. The output is the amount taxes, the subtotal, and the grand total.

**/
package replit;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;



public class Main extends Application 
{ 
  
  @Override
  public void start(Stage primaryStage) {
    
    //Define your variables here
    
    Label Sublabel; 
    Label Label1; 
    Label Label2; 
    Label Label3; 
    Label Label4;
    Label Label5;
    Label amtTaxes;
    Label taxPrice;
    Label Subtotal;
    Label subPrice;
    Label grandTotal;
    Label grandPrice;
    TextField tf1;
    TextField tf2;
    TextField tf3;
    TextField tf4;
    TextField tf5;
    Button button;
    VBox vbox;
    HBox hbox1;
    HBox hbox2;
    HBox hbox3;
    HBox hbox4;
    HBox hbox5;
    Scene scene;

    //pixels are set for proportionalities
    //Red color is used for labels and text fields
    
    tf1 = new TextField("0");
    tf1.setMaxWidth(50);

    tf2 = new TextField("0");
    tf2.setMaxWidth(50);

    tf3 = new TextField("0");
    tf3.setMaxWidth(50);

    tf4 = new TextField("0");
    tf4.setMaxWidth(50);

    tf5 = new TextField("0");
    tf5.setMaxWidth(50);

    //Message to users on how they can purchase pizza slices

    Sublabel = new Label("Please enter the number of slices that you would like to purchase and click. Calculate.");
    Sublabel.setTextFill(Color.RED);


    //Labels defined to be the type of pizza slice are initialised

    Label1 = new Label("New York-Style Pizza ($5.25):");
    Label1.setTextFill(Color.RED);
    
    Label2 = new Label("Greek Pizza ($4.75):");
    Label2.setTextFill(Color.RED);
    
    Label3 = new Label("St. Louis Pizza ($3.25):");
    Label3.setTextFill(Color.RED);
    
    Label4 = new Label("Neapolitan Pizza ($1.75):");
    Label4.setTextFill(Color.RED);
    
    Label5 = new Label("California Pizza ($2.50)");
    Label5.setTextFill(Color.RED);

    //Load image pizzaGuy.png
    //Image height is set with no changes to ratio

    Image img = new Image("images/pizzaGuy.png");
    ImageView view = new ImageView(img);
    view.setFitHeight(80);
    view.setPreserveRatio(true);

    //Label called myLabel is initialised
    //Will be placed in hbox1

    Label myLabel = new Label("", view);

    //Button used to calculate the subtotal, amount tax, and grand total
    
    button = new Button("Calculate");
    button.setTextFill(Color.RED);

    amtTaxes = new Label("Taxes (13%):");
    amtTaxes.setTextFill(Color.RED);
    Subtotal = new Label("Subtotal:");
    Subtotal.setTextFill(Color.RED);
    grandTotal = new Label("Grand Total:");
    grandTotal.setTextFill(Color.RED);

    //Default prices of 0 pizza slices

    taxPrice = new Label("$0.00");
    taxPrice.setTextFill(Color.RED);
    subPrice = new Label("$0.00");
    subPrice.setTextFill(Color.RED);
    grandPrice = new Label("$0.00");
    grandPrice.setTextFill(Color.RED);

    button.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent e) {
        
        //Parsing text data into a integer

      int n1 = Integer.parseInt(tf1.getText());
      int n2 = Integer.parseInt(tf2.getText());
      int n3 = Integer.parseInt(tf3.getText());
      int n4 = Integer.parseInt(tf4.getText());
      int n5 = Integer.parseInt(tf5.getText());

        //The value num1 is set to be the operation to calculate subprice
        //subPrice is rounded to 2 decimal places and set

        double num1 = n1*5.25 + n2*4.75 + n3*3.25 + n4*1.75 + n5*2.50;
        subPrice.setText("$" + (Math.round(num1*100.0) / 100.0)); 
 
        //the value of num2 is set to be the opperation to calculate taxPrice
        // taxprice is rounded to 2 decimal places and set
        //constant TAX_RATE is set for the tax rate equal to 0.13

        final double TAX_RATE = 0.13;

        double num2 = num1*TAX_RATE;
        taxPrice.setText("$" + (Math.round(num2*100.0) / 100.0));

        //taxPrice is rounded to 2 decimal places

        grandPrice.setText("$" + (Math.round((num1 + num2)*100.0) / 100.0));

      }
  
    });

    //Horizantal boxes are initialised, spaced, and positioned to the center-left here.
    //Center-left position will allow me to keep my label widgets organised.
    
    hbox1 = new HBox(Label1, tf1, myLabel);
    hbox1.setSpacing(56);
    hbox1.setAlignment(Pos.CENTER_LEFT);

    hbox2 = new HBox(Label2, tf2, button);
    hbox2.setSpacing(90);
    hbox2.setAlignment(Pos.CENTER_LEFT);

    hbox3 = new HBox(Label3, tf3, amtTaxes, taxPrice);
    hbox3.setSpacing(48);
    hbox3.setAlignment(Pos.CENTER_LEFT);

    hbox4 = new HBox(Label4, tf4, Subtotal, subPrice);
    hbox4.setSpacing(52);
    hbox4.setAlignment(Pos.CENTER_LEFT);

    hbox5 = new HBox(Label5, tf5, grandTotal, grandPrice);
    hbox5.setSpacing(49);
    hbox5.setAlignment(Pos.CENTER_LEFT);

    //Vertical Boxes are initialised, spaced, and positioned to the center-left here.
    
    vbox = new VBox(Sublabel, hbox1, hbox2, hbox3, hbox4, hbox5);
    vbox.setSpacing(50);
    vbox.setAlignment(Pos.CENTER_LEFT);

    //Scene is set to it's appropriate proportionality
    scene = new Scene(vbox, 564, 450);

    primaryStage.setTitle("Sahil's Pizzaria!");
    primaryStage.setScene(scene);
    primaryStage.show();
  } 
    
  public static void main(String[] args) {
    launch(args);
  }
} 
