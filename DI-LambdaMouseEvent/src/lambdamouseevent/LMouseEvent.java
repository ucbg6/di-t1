/*
    Uriel Caracuel Barrera - 2º DAM
    Desarrollo de Interfaces - Tema 1
    4.3.3 - Expresiones Lambda - MouseEvent.java
 */
package lambdamouseevent;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class LMouseEvent extends Application {
    
    
    @Override
    public void start(Stage primaryStage) {
        Text t = new Text(50,50,"Mueveme con el ratón");
        t.setFocusTraversable(true);
        
        t.setOnMouseDragged( e -> {
            t.setX(e.getX());
            t.setY(e.getY());
            
        
        });

        
        
        // Stage
        Pane root = new Pane();
        root.getChildren().add(t);
        
        Scene scene = new Scene(root,250,250);
        
        primaryStage.setTitle("MouseEvent");
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
