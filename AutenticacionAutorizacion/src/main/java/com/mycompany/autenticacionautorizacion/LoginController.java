/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.autenticacionautorizacion;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.mycompany.autenticacionautorizacion.dao.UsuarioDAO;
import com.mycompany.autenticacionautorizacion.basededatos.UsuarioSesion;
import com.mycompany.autenticacionautorizacion.modelo.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class LoginController implements Initializable {
    @FXML private TextField txtCredencial;
    @FXML private PasswordField txtPassword;
    @FXML private Label lblError;

    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    @FXML
    private void iniciarSesion(ActionEvent event) {
        String credencial = txtCredencial.getText();
        String password = txtPassword.getText();

        if (credencial.isEmpty() || password.isEmpty()) {
            lblError.setText("Por favor, llena todos los campos.");
            return;
        }

        Usuario usuario = usuarioDAO.validarLogin(credencial, password);

        if (usuario != null) {
            UsuarioSesion.getInstancia().setUsuarioActivo(usuario);
            cargarVentanaPrincipal(event);
        } else {
            lblError.setText("Credenciales incorrectas o cuenta inactiva.");
        }
    }
    
    private void cargarVentanaPrincipal(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("primary.fxml")); 
            Stage stage = new Stage();
            stage.setTitle("Clínica - Panel Principal");
            stage.setScene(new Scene(root));
            stage.show();
            
            
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            lblError.setText("Error al cargar la ventana principal.");
            e.printStackTrace();
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
