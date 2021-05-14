/*
    Uriel Caracuel Barrera - 2º DAM
    EFadeTransition.java
 */
package fadetransition;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

public class EFadeTransition extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Ellipse ellipse = new Ellipse(10, 10, 100, 60);
        ellipse.setFill(Color.BLUEVIOLET);
    // Applica una fade transition a elipse
    FadeTransition ft = new FadeTransition(Duration.millis(3000),ellipse);
    ft.setFromValue(1.0);
    ft.setToValue(0.1);
    ft.setCycleCount(Timeline.INDEFINITE);
    ft.setAutoReverse(true);
    ft.play();// Start animation
    // Control animation
    ellipse.setOnMousePressed(e->ft.pause());
    ellipse.setOnMouseReleased(e->ft.play());
        
        StackPane root = new StackPane();
        root.getChildren().add(ellipse);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("FadeTransition Example");
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
