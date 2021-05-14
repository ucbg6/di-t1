/*
    Uriel Caracuel Barrera - 2º DAM
    LKeyEvent.java
 */
package lambdakeyevent;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LKeyEvent extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Text t = new Text(20,20,"A");
        t.setFocusTraversable(true);
        
        t.setOnKeyPressed( ev -> {
            double x = t.getX();
            double y = t.getY();
            /* 
            if (ev.getCode() == KeyCode.UP){
                System.out.println("Tecla arriba presionada");
                t.setY(y - 10);
            }
            if (ev.getCode() == KeyCode.LEFT){
                System.out.println("Tecla izquierda presionada");
                t.setX(x - 10);
            }
            if (ev.getCode() == KeyCode.RIGHT){
                System.out.println("Tecla derecha presionada");
                t.setX(x + 10);
            }
            if (ev.getCode() == KeyCode.DOWN){
                System.out.println("Tecla abajo presionada");
                t.setY(y + 10);
            }
            */
            
            switch (ev.getCode()){
                case UP:{
                    t.setY(y - 10);
                    break;
                }                
                case DOWN:{
                    t.setY(y + 10);
                    break;
                }
                case LEFT:{
                   t.setX(x - 10);
                   break;
                }
                case RIGHT:{
                   t.setX(x + 10);
                   break;
                }
                default:{
                    String c = ev.getText();
                    if (Character.isLetterOrDigit(c.charAt(0))){
                  
                       t.setText(c); 
                    }
                    
                }
                

            }
                
        });
        
        
        
        
        
        Pane root = new Pane();
        root.getChildren().add(t);
        
        Scene scene = new Scene(root, 300, 100);
        
        primaryStage.setTitle("LambdaKeyEvent");
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
