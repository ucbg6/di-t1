/*
    Uriel Caracuel Barrera - 2º DAM
    RPathTransition.java
 */
package pathtransition;

import javafx.animation.Interpolator;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class RPathTransition extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        // Círculo
        Circle c = new Circle(150, 150, 100);
        c.setFill(Color.TRANSPARENT);
        c.setStroke(Color.BLACK);
        
        // Rectángulo
        Rectangle r = new Rectangle(75,50);
        r.setFill(Color.GOLDENROD);
        
        // PathTransition
        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(4000));
        // El círculo es el camino
        pt.setPath(c);
        // El rectángulo lo recorre
        pt.setNode(r);
        // Rectángulo tangente al círculo
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        // Se repite indefinidamente
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setInterpolator(Interpolator.LINEAR);

        pt.play();// Inicia la animación
        // Si se mantiene presionado el círculo, la animación se pausa
        c.setOnMousePressed(e -> pt.pause());
        c.setOnMouseReleased(e -> pt.play());
        
        Pane root = new Pane();
        root.getChildren().addAll(c,r);
        
        Scene scene = new Scene(root, 300, 300);
        
        primaryStage.setTitle("RPathTransition");
        primaryStage.setResizable(false);
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
