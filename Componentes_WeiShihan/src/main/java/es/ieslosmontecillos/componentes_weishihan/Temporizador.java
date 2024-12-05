/**
 * 2º DAM DI
 * Tema 3: Creación de componentes visuales
 * @author Shihan
 * 4.7. Implementación Componente intermedio
 * Componente: Temporizador
 * Proyecto Componentes_WeiShihan
 */

package es.ieslosmontecillos.componentes_weishihan;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.IOException;


public class Temporizador extends VBox {

    @FXML
    private Label tiempoRestante;
    @FXML
    private Label tiempoTotal;

    private IntegerProperty tiempo = new SimpleIntegerProperty();

    /* Definimos el atributo cuentaAtras para marcar el cambio del valor de tiempo */
    private final Timeline cuentaAtras = new Timeline();

    public Temporizador() {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("temporizador.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        /* Establecemos un tiempo por defecto (1 minuto) */
        this.setTiempo(60);

        /* Establecemos un evento por defecto para el setOnFinished */
        this.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Fin del temporizador. Mensaje por defecto.");
            }
        });
    }

    /* Atributo: acción a realizar una vez que se termine el evento */
    public ObjectProperty<EventHandler<ActionEvent>> onFinished = new SimpleObjectProperty<>();

    /* ActionEvent al finalizar el contador a definir por el usuario */
    public final ObjectProperty<EventHandler<ActionEvent>> onFinishedProperty() {
        return onFinished;
    }

    public final void setOnFinished(EventHandler<ActionEvent> onFinished) {
        this.onFinishedProperty().set(onFinished);
    }

    public final EventHandler<ActionEvent> getOnFinished() {
        return onFinished.get();
    }

    /* Setter y getter del tiempo establecido a cronometrar */
    public IntegerProperty tiempoProperty() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        tiempoProperty().set(tiempo);
    }

    public int getTiempo() {
        return tiempoProperty().get();
    }

    /* Pone en marcha al temporizador */
    public void play()
    {
        /* Definimos los argumentos necesarios para el Timeline */
        KeyValue kv = new KeyValue(tiempo, 0);
        KeyFrame kf = new KeyFrame(Duration.seconds(tiempo.get()), onFinished.get(), kv);
        cuentaAtras.getKeyFrames().add(kf);

        /* Determinamos el valor de las etiquetas  */
        tiempoTotal.setText("Cuenta atrás: " + getTiempo() + " segundos");
        tiempoRestante.setText(String.valueOf(getTiempo()));

        /* Ejecutamos el Timeline */
        cuentaAtras.play();

        /* Actualizamos la etiqueta del tiempo restante conforme que se realiza la cuenta atrás
        * Lo podemos hacer tanto con bind o con un listener*/
        tiempoRestante.textProperty().bind(tiempo.asString());
    }

}
