/**
 * 2º DAM DI
 * Tema 3: Creación de componentes visuales
 * @author Shihan
 * Componente: CampoTextoBoton
 * Proyecto Componentes_WeiShihan
 */

package es.ieslosmontecillos.componentes_weishihan;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class CampoTextoBoton extends HBox {
    @FXML
    private TextField textField;
    @FXML
    private Button buttonText;


    public CampoTextoBoton() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "campo_texto_boton.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        buttonText.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                /* Solo actúa cuando se ha definido el manejador para el evento */
                fireEvent(event);
            }
        });
    }

    /* Permite definir onAction del componente */
    private ObjectProperty<EventHandler<ActionEvent>> onAction = new ObjectPropertyBase<>() {
        @Override
        protected void invalidated() {
            setEventHandler(ActionEvent.ACTION, get());
        }

        @Override
        public Object getBean() {
            return CampoTextoBoton.this;
        }

        @Override
        public String getName() {
            return "onAction";
        }
    };

    public final ObjectProperty<EventHandler<ActionEvent>> onActionProperty(){
        return onAction;
    }

    public final void setOnAction(EventHandler<ActionEvent> handler) {
        onActionProperty().set(handler);
    }

    public final EventHandler<ActionEvent> getOnAction() {
        return onAction.get();
    }

    /* Texto del textfield */
    public String getText() {
        return textProperty().get();
    }

    public void setText(String value) {
        textProperty().set(value);
    }

    public StringProperty textProperty() {
        return textField.textProperty();
    }

    /* Texto del botón */
    public String getButtonText() {
        return buttonTextProperty().get();
    }

    public void setButtonText(String value) {
        buttonTextProperty().set(value);
    }

    public StringProperty buttonTextProperty() {
        return buttonText.textProperty();
    }

}
