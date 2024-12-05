/**
 * 2º DAM DI
 * Tema 3: Creación de componentes visuales
 * @author Shihan
 * Componente: CampoTextoNumerico
 * Proyecto Componentes_WeiShihan
 */

package es.ieslosmontecillos.componentes_weishihan;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CampoTextoNumerico extends TextField {

    public CampoTextoNumerico()
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("campo_texto_numerico.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void replaceText(int start, int end, String text)
    {
        if(!text.matches("[^0-9.]")){
            super.replaceText(start, end, text);
        }
        else
            this.setText("Debe introducir valores numéricos.");
    }

    /* se activa cuando al Textfield se le pasa un bloque de texto en conjunto (Portapapeles) */
    @Override
    public void replaceSelection(String text)
    {
        if(text.matches("^[0-9]+(\\.[0-9]+)$") || text.matches("^[0-9]+$")){
            super.replaceSelection(text);
        }
    }

}
