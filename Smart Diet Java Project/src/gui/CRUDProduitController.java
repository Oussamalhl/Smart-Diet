/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Produit;
import java.io.IOException;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import services.CRUDProduit;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import utils.MyConnection;

/**
 * FXML Controller class
 *
 * @author Moez
 */
public class CRUDProduitController implements Initializable {

    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfdescription;
    @FXML
    private TextField tfquantite;
    @FXML
    private TextField tfprix;
    @FXML
    private TextField tfstatut;
    @FXML
    private Button btnHomeTransition;
    @FXML
    private Button btnAddProduit;
    @FXML
    private Button btnEditProduit;
    @FXML
    private Button btnDeleteProduit;
    @FXML
    private TableView<Produit> tabProduit;
    @FXML
    private TableColumn<Produit,Integer> colcodeProduit;
    @FXML
    private TableColumn<Produit,String> colnom;
    @FXML
    private TableColumn<Produit,String> coldescription;
    @FXML
    private TableColumn<Produit,Integer> colquantite;
    @FXML
    private TableColumn<Produit,Float> colprix;
    @FXML
    private TableColumn<Produit,String> colstatut;
     @FXML
    private TableColumn<Produit,String> colcategorie;
    ObservableList<Produit> listA;
    ObservableList<Produit> dataList; 
    ObservableList<PieChart.Data> piechartdata;
    int index = -1;
    @FXML
    private TextField tfcodeProduit;
    @FXML
    private TextField tfRecherche;
    @FXML
    private TextField tfcategorie;
    @FXML
    private PieChart stat_produit;

//   ObservableList<Produit> list = FXCollections.observableArrayList();
   
    /**
     * Initializes the controller class.
     */
    void recherche_Produit() {
        colcodeProduit.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("codeProduit"));
        colnom.setCellValueFactory(new PropertyValueFactory<Produit,String>("nom"));
        coldescription.setCellValueFactory(new PropertyValueFactory<Produit, String>("description"));
        colquantite.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("quantite"));
        colprix.setCellValueFactory(new PropertyValueFactory<Produit, Float>("prix"));
        colstatut.setCellValueFactory(new PropertyValueFactory<Produit, String>("statut"));
        colcategorie.setCellValueFactory(new PropertyValueFactory<Produit, String>("categorie"));

        CRUDProduit pa = new CRUDProduit();
        dataList = pa.afficherProduit();
        tabProduit.setItems(dataList);

        FilteredList<Produit> filteredData = new FilteredList<>(dataList, b -> true);
        tfRecherche.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(Produit -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();
                if (Produit.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (Produit.getStatut().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        SortedList<Produit> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tabProduit.comparatorProperty());
        tabProduit.setItems(sortedData);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            // TODO
            loadDataPie();
        } catch (SQLException ex) {
            Logger.getLogger(CRUDProduitController.class.getName()).log(Level.SEVERE, null, ex);
        } 
         stat_produit.setData(piechartdata);
        tfcodeProduit.setText(null);
        tfnom.setText(null);
        tfdescription.setText(null);
        tfquantite.setText(null);
        tfprix.setText(null);
        tfstatut.setText(null);
        tfcategorie.setText(null);
        
        majTable();
        recherche_Produit();
    }    

    @FXML
    private void HomeTransition(ActionEvent event) throws IOException { 
         FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeFXML.fxml"));
            Parent parent=loader.load();
            HomeFXMLController alc= loader.getController();
            
            
            tfstatut.getScene().setRoot(parent);
    }

    @FXML
    private void AddProduit(ActionEvent event) { 
        
         
        String pnom = tfnom.getText();
        String pdescription = tfdescription.getText();
        int pquantite = parseInt(tfquantite.getText());
        float pprix = parseFloat(tfprix.getText());
        String pstatut = tfstatut.getText();
        String pcategorie = tfcategorie.getText();
        
//        String pid_categories = tfid_categories.getText(); 
////        int pid_categories = Integer.parseInt(pid_categories); 
       
        Produit p = new Produit(pnom, pdescription, pquantite, pprix, pstatut,pcategorie);
        CRUDProduit pm = new CRUDProduit();
        pm.ajouterProduits(p);
        recherche_Produit();
        majTable();
    }

    @FXML
    private void EditProduit(ActionEvent event) {
        String qcodeProduit = tfcodeProduit.getText();
        String qnom = tfnom.getText();
        String qdescription = tfdescription.getText();
        int qqauntite = parseInt(tfquantite.getText());
        float qprix = parseFloat(tfprix.getText());
        String qstatut = tfstatut.getText();
        String qcategorie = tfcategorie.getText();
        
      

int codeProduit = Integer.parseInt(qcodeProduit);


        Produit P = new Produit(codeProduit,qnom,qdescription,qqauntite,qprix,qstatut,qcategorie);
        CRUDProduit cds = new CRUDProduit();
        cds.UpdateProduit(P);
        recherche_Produit();
        majTable(); 
     
        
     
    }

    @FXML
    private void DeleteProduit(ActionEvent event) {
        String qcodeProduit = tfcodeProduit.getText();
        int codeProduit = Integer.parseInt(qcodeProduit);
         CRUDProduit cda = new CRUDProduit();
        cda.DeleteProd(codeProduit);
        recherche_Produit();
        majTable();
        
    }
    
    public void majTable() {

        colcodeProduit.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("codeProduit"));
        colnom.setCellValueFactory(new PropertyValueFactory<Produit,String>("nom"));
        coldescription.setCellValueFactory(new PropertyValueFactory<Produit, String>("description"));
        colquantite.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("quantite"));
        colprix.setCellValueFactory(new PropertyValueFactory<Produit, Float>("prix"));
        colstatut.setCellValueFactory(new PropertyValueFactory<Produit, String>("statut"));
        colcategorie.setCellValueFactory(new PropertyValueFactory<Produit, String>("categorie"));

        CRUDProduit cda = new CRUDProduit();
        listA = cda.afficherProduit();
        tabProduit.setItems(listA);
    }
   
 @FXML
    private void getSelectedProduit(MouseEvent event) {
        index = tabProduit.getSelectionModel().getSelectedIndex();
        if (index <= -1) {

            return;
        }

        tfcodeProduit.setText(colcodeProduit.getCellData(index).toString());
        tfnom.setText(colnom.getCellData(index));
        tfdescription.setText(coldescription.getCellData(index));
        tfquantite.setText(colquantite.getCellData(index).toString());
        tfprix.setText(colprix.getCellData(index).toString());
        tfstatut.setText(colstatut.getCellData(index).toString());
        tfcategorie.setText(colcategorie.getCellData(index).toString());
    }
    public void loadDataPie() throws SQLException
    {
        piechartdata = FXCollections.observableArrayList();
        String requete = "select o.description,count(o.codeProduit) as nbadd from produit o group by o.description";
            PreparedStatement pst= new MyConnection().cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
            piechartdata.add(new PieChart.Data(rs.getString("description"), rs.getInt("nbadd")));

        }
    }
     
    
    
} 

