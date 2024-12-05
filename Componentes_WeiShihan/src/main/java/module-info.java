module es.ieslosmontecillos.componentes_weishihan {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.ieslosmontecillos.componentes_weishihan to javafx.fxml;
    exports es.ieslosmontecillos.componentes_weishihan;
}