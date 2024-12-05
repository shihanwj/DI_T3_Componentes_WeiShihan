/**
 * 2º DAM DI
 * Tema 3: Creación de componentes visuales
 * @author Shihan
 * Proyecto Componentes_WeiShihan
 */

package es.ieslosmontecillos.componentes_weishihan;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Componentes_WeiShihan extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Label etiqueta = new Label("ControlPersonalizado");
        CampoTextoBoton campoTextoBoton = new CampoTextoBoton();
        CampoTextoNumerico campoTextoNumerico = new CampoTextoNumerico();
        campoTextoBoton.setText("Hello");

        Temporizador temporizador = new Temporizador();

        temporizador.setTiempo(15);
        temporizador.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("He llegado a mi fin.");
                stage.close();
            }
        });

        VBox vBox = new VBox(etiqueta, campoTextoBoton, campoTextoNumerico, temporizador);
        temporizador.play();

        Scene scene = new Scene(vBox, 300, 200);
        stage.setTitle("Componentes WeiShihan");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}