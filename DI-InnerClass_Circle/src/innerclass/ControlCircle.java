/*
    Uriel Caracuel Barrera - 2º DAM
    ControlCircle.java
 */
package innerclass;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ControlCircle extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        // Componentes de la ventana
        Circle c1 = new Circle(50.0f);
        c1.setFill(Color.TRANSPARENT);
        c1.setStroke(Color.BLACK);
        
        Button bt1 = new Button("Agrandar");
        bt1.setPadding(new Insets(15,15,15,15));
        
        Button bt2 = new Button("Encoger");
        bt2.setPadding(new Insets(15,15,15,15));
        
        // Inner Class bt1 (Agranda el círculo)
        class EnlargeHandler implements EventHandler<ActionEvent>{
            
            double r = c1.getRadius();
           
            @Override
            public void handle(ActionEvent e){
                System.out.println("El círculo se ha agrandado");
                c1.setRadius( c1.getRadius() + 2 );
                
            }      
        }
        
        // Inner Class bt2 (Encoge el círculo)
        class ShrinkHandler implements EventHandler<ActionEvent>{
            
            double r = c1.getRadius();
           
            @Override
            public void handle(ActionEvent e){
                System.out.println("El círculo se ha encogido");
                c1.setRadius( c1.getRadius() - 2 );
            }      
        }
        
        // Eventos para los botones
        bt1.setOnAction(new EnlargeHandler());
        bt2.setOnAction(new ShrinkHandler());
        
        HBox bts = new HBox();
        bts.setPadding(new Insets(15,15,15,15));
        bts.setAlignment(Pos.CENTER);
        bts.setSpacing(20);
        bts.getChildren().addAll(bt1,bt2);
        
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        // root.setPadding(new Insets(15,15,15,15));
        bts.setSpacing(20);
        root.getChildren().addAll(c1,bts);
        
        Scene scene = new Scene(root, 400, 400);
        
        primaryStage.setTitle("ControlCircle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
