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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ih3b
 */
public class HomeController implements Initializable {

    private Button btnProduit;
    @FXML
    private AnchorPane pane; 
    @FXML
    private Button btnFacture;
    @FXML
    private Button btnPayment;
    @FXML
    private Button btnFacture1;
    @FXML
    private Circle circle;
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   


    private void CRUDProduitTransition(ActionEvent event) { 
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CRUDProduit.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setTitle("Gestion des Produits");
            Scene sceneAg = new Scene(root);           
            stage.setScene(sceneAg);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    private void CRUDCategoriesTransition(ActionEvent event) { 
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CRUDCategories.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setTitle("Gestion des Catégories");
            Scene sceneAg = new Scene(root);           
            stage.setScene(sceneAg);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void emailtransition(ActionEvent event) {
              try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Email.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setTitle("Email");
            Scene sceneSp = new Scene(root);           
            stage.setScene(sceneSp);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void onRetour(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeFXML.fxml"));
            Parent parent=loader.load();
            HomeFXMLController alc= loader.getController();
            
            
            btnProduit.getScene().setRoot(parent);
    }

    @FXML
    private void CRUDFacturesTransition(ActionEvent event) {
    }

    @FXML
    private void CRUDPaymentTransition(ActionEvent event) {
    }

    @FXML
    private void play(ActionEvent event) {
    }

    @FXML
    private void play(MouseDragEvent event) {
    }
    
}
