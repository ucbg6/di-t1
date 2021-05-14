/*
    Uriel Caracuel Barrera - 2º DAM
    Desarrollo de Interfaces - Tema 1
    4.3.2 - Expresiones Lambda - Buttons.java
 */
package aninnerclass_buttons;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class Buttons extends Application {
    
    @Override
    @SuppressWarnings("Convert2Lambda")
    public void start(Stage primaryStage) {
        
        // Botones
        Button bn = new Button("Nuevo");
        Button ba = new Button("Abrir");
        Button bg = new Button("Guardar");
        Button bi = new Button("Imprimir");
        
        bn.setPadding(new Insets(15,15,15,15));
        ba.setPadding(new Insets(15,15,15,15));
        bg.setPadding(new Insets(15,15,15,15));
        bi.setPadding(new Insets(15,15,15,15));
        
        // Nuevo

        bn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e){
                    System.out.println("Nuevo proceso");
                }
            });
        
        // Abrir
        ba.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e){
                    System.out.println("Abrir proceso");
                }
            });      
        
        // Guardar
        bg.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e){
                    System.out.println("Guardar proceso");
                }
            }); 
        
        // Imprimir
        bi.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e){
                    System.out.println("Imprimir proceso");
                }
            });         
        
        // Stage
        HBox root = new HBox();
        
        root.setPadding(new Insets(15,15,15,15));
        root.setSpacing(20);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(bn,ba,bg,bi);        
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("AnonymousHandlerDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
