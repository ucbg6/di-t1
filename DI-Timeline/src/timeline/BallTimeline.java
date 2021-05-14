/*
    Uriel Caracuel Barrera - 2º DAM
    BallTimeline.java
 */

package timeline;

import com.sun.javafx.perf.PerformanceTracker;
import javafx.animation.KeyFrame;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;


public class BallTimeline extends Application {
    
    public static double dx = Math.random() % 20 + 10;
    public static double dy = Math.random() % 20 + 10;
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        // Bola que se usará para la animación
        Circle ball = new Circle(10);
        ball.relocate((double)300*0.5, (double)200*0.5);
        ball.setFill(Color.DARKMAGENTA);
        pane.getChildren().add(ball);

        // Etiqueta que mostrará el valor de frames por segundo (FPS)
        Label label = new Label();
        label.setTranslateX(10);
        label.setTranslateY(10);
        
        pane.getChildren().add(label);
        Scene scene = new Scene(pane, 300, 250);
        
        primaryStage.setTitle("BallTimeline");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        EventHandler<ActionEvent> eH = e -> {

            // Mostrar la frecuencia de refresco FPS
            PerformanceTracker perfTracker = PerformanceTracker.getSceneTracker(scene);
            label.setText("FPS (Timeline) = " + perfTracker.getInstantFPS());
            
            ball.setLayoutX(ball.getLayoutX() + dx);
            ball.setLayoutY(ball.getLayoutY() + dy);

            Bounds borde = pane.getBoundsInLocal();

            if (ball.getLayoutX() <= (borde.getMinX() + ball.getRadius())
                    || ball.getLayoutX() >= (borde.getMaxX() - ball.getRadius())) {
                dx = -dx;
            }

            if ((ball.getLayoutY() >= (borde.getMaxY() - ball.getRadius()))
                    || (ball.getLayoutY() <= (borde.getMinY() + ball.getRadius()))) {
                dy = -dy;
            }
        
        };
        
        Timeline t = new Timeline(new KeyFrame(Duration.millis(500), eH));
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();   
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
