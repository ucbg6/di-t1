/*
    Uriel Caracuel Barrera - 2º DAM
    CalculadoraPrestamos.java
 */
 
package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class CalculadoraPrestamos extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        // Padding
        Insets pad = new Insets(20,20,20,20);
         
        // Contenedor principal
        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(pad);
        root.setAlignment(Pos.CENTER);
        
        // Tasa de interés anual
        Label lb_intanual = new Label("Tasa de Interés Anual");
        TextField tb_intanual = new TextField();
        tb_intanual.setPrefWidth(200);
        
        // Periodo
        Label lb_numy = new Label("Periodo en años");
        TextField tb_numy = new TextField();
     
        // Cantidad
        Label lb_pres = new Label("Cantidad");
        TextField tb_pres = new TextField();

        // Pago mensual
        Label lb_pagom = new Label("Cuota mensual");
        TextField tb_pagom = new TextField();
        tb_pagom.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
        
        // Pago Total
        Label lb_pagot = new Label("Pago total");
        TextField tb_pagot = new TextField();
        tb_pagot.setFont(Font.font("Calibri", FontWeight.NORMAL, 20));
        
        // Mensaje de información
        Label mensaje = new Label();
        mensaje.setVisible(false);
        
        // Botón Calcular
        Button calc = new Button("Calcular");
        calc.setPadding(new Insets(10,10,10,10));
        calc.setPrefWidth(100);
        
        // Control de eventos
        calc.setOnAction((ActionEvent event) -> {
            
            try{
                int ctrl = 0;

                if ("".equals(tb_intanual.getText()) || "".equals(tb_numy.getText()) || "".equals(tb_pres.getText())) ctrl++;

                if (ctrl == 0){
                    double i = Double.parseDouble(tb_intanual.getText());
                    double h = Double.parseDouble(tb_pres.getText());
                    double n = Double.parseDouble(tb_numy.getText());
                    double r = i / (100 * 12);

                    double m = (h*r)/(1-(1/(Math.pow((1+r),12*n))));
                    double total = m*12*n;

                    if (i == 0){
                        m = h/n/12;
                        total = h;
                    }
                    tb_pagom.setText(String.format("%.2f EUR",m));
                    tb_pagot.setText(String.format("%.2f EUR",total));
                    mensaje.setText("Interés calculado correctamente");
                    mensaje.setTextFill(Color.GREEN);
                }else{
                    mensaje.setTextFill(Color.RED);
                    mensaje.setText("Error. Faltan datos");


                }
                mensaje.setVisible(true); 

            
            }catch (NumberFormatException ex){
                mensaje.setTextFill(Color.RED);
                mensaje.setText("Error. Los datos introducidos deben ser numéricos");
                mensaje.setVisible(true);  
            }
        });
    
        // Construcción de la ventana
        root.add(lb_intanual,0,0);
        root.add(tb_intanual,1,0);
        root.add(lb_numy,0,1);
        root.add(tb_numy,1,1);
        root.add(lb_pres,0,2);
        root.add(tb_pres,1,2);
        root.add(lb_pagom,0,3);
        root.add(tb_pagom,1,3);
        root.add(lb_pagot,0,4);
        root.add(tb_pagot,1,4);
        
        root.add(calc,1,5);
        root.add(mensaje,0,6,2,1);
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Calculadora de Prestamos");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
