/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Thrall
 */
public class HomeFXMLController implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private Button commande;
    @FXML
    private Button Statistique;
    @FXML
    private Button buttLiv;
    @FXML
    private Button buttRec;
    @FXML
    private Button buttLiv1;
    @FXML
    private Button buttLiv11;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void commandePress(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CommandeFXML.fxml"));
            Parent parent=loader.load();
            CommandeFXMLController alc= loader.getController();
            
            
            buttLiv.getScene().setRoot(parent);
        } catch (IOException ex) {
            Logger.getLogger(HomeFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }


    @FXML
    private void versLivraison(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeLivraisonFXML.fxml"));
            Parent parent=loader.load();
            HomeLivraisonFXMLController alc= loader.getController();
            
            
            buttLiv.getScene().setRoot(parent);
        } catch (IOException ex) {
            Logger.getLogger(HomeFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }


    @FXML
    private void versReclamation(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeReclamationFXML.fxml"));
            Parent parent=loader.load();
            HomeReclamationFXMLController alc= loader.getController();
            
            
            buttLiv.getScene().setRoot(parent);
        } catch (IOException ex) {
            Logger.getLogger(HomeFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void LignePress(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LigneCommandeFXML.fxml"));
            Parent parent=loader.load();
            LigneCommandeFXMLController alc= loader.getController();
            
            
            buttLiv.getScene().setRoot(parent);
        } catch (IOException ex) {
            Logger.getLogger(HomeFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void onLogOut(ActionEvent event) throws IOException {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent parent=loader.load();
            LoginController alc= loader.getController();
            
            
            buttLiv.getScene().setRoot(parent);
    }

    @FXML
    private void onProduct(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CRUDProduit.fxml"));
            Parent parent=loader.load();
            CRUDProduitController alc= loader.getController();
            
            
            buttLiv.getScene().setRoot(parent); 
    }

    @FXML
    private void onUser(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("gestionUserFXML.fxml"));
            Parent parent=loader.load();
            GestionUserFXMLController alc= loader.getController();
            
            
            buttLiv.getScene().setRoot(parent);
    }

    @FXML
    private void onRdv(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Template.fxml"));
            Parent parent=loader.load();
            TemplateController alc= loader.getController();
            
            
            buttLiv.getScene().setRoot(parent);
        
    }

    @FXML
    private void onPayment(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("home_1.fxml"));
            Parent parent=loader.load();
            HomeController_1 alc= loader.getController();
            
            
            buttLiv.getScene().setRoot(parent);
        
    }
    
}
