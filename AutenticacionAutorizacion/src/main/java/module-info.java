module com.mycompany.autenticacionautorizacion {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql; 

    opens com.mycompany.autenticacionautorizacion to javafx.fxml;
    exports com.mycompany.autenticacionautorizacion;
    
   
    opens com.mycompany.autenticacionautorizacion.modelo to javafx.base;


}
