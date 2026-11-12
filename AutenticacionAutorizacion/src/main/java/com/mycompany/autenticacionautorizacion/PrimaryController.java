package com.mycompany.autenticacionautorizacion;

import com.mycompany.autenticacionautorizacion.basededatos.UsuarioSesion;
import com.mycompany.autenticacionautorizacion.modelo.Usuario;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PrimaryController {

  
    @FXML private Label lblBienvenida;
    @FXML private Button btnGestionUsuarios; 
    @FXML private Button btnEliminarDatos;   
    @FXML private Button btnCerrarSesion;

    @FXML
    public void initialize() {
        aplicarPermisos();
    }

    private void aplicarPermisos() {
        Usuario usuarioActual = UsuarioSesion.getInstancia().getUsuarioActivo();
        
        // Si por alguna razón no hay sesión, salir por seguridad
        if (usuarioActual == null) return; 

        lblBienvenida.setText("Bienvenido, " + usuarioActual.getRol() + " (" + usuarioActual.getCorreo() + ")");

        String rol = usuarioActual.getRol();


        switch (rol) {
            case "Administrador":
                break;
                
            case "Recepcionista":
               
                btnGestionUsuarios.setVisible(false);
                btnGestionUsuarios.setManaged(false); // Quita el espacio visual
                break;
                
            case "Médico":
                
                btnGestionUsuarios.setVisible(false);
                btnGestionUsuarios.setManaged(false);
                
                btnEliminarDatos.setDisable(true); 
                break;
        }
    }

    @FXML
    private void cerrarSesion(ActionEvent event) {
        // Limpiar los datos del usuario activo en el Singleton
        UsuarioSesion.getInstancia().cerrarSesion();
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Inicio de Sesión");
            stage.setScene(new Scene(root));
            stage.show();
            
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            System.err.println("Error al cerrar sesión: " + e.getMessage());
        }
    }
}