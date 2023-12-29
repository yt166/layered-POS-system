package controller;

import com.jfoenix.controls.*;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import dto.tm.CustomerTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CustomerController {
    public AnchorPane CustomerPane;
    public Button btnBack;
    public ImageView imgCustomer;
    public Label lblCusID;
    public Label lblCusName;
    public Label lblCusAddress;
    public Label lblCusSalary;
    public Label lblGenID;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtSalary;
    public JFXButton btnSave;
    public JFXComboBox cmbCustomerID;
    public JFXTextField txtUpdateName;
    public JFXTextField btnUpdateSalry;
    public JFXTextField txtUpdateAddress;
    public JFXButton btnUpdate;
    public JFXTreeTableView tblCustomer;
    public TreeTableColumn colID;
    public TreeTableColumn colName;
    public TreeTableColumn colAddress;
    public TreeTableColumn colSalary;
    public JFXButton btnDelete;

    public void initialize(){
        generateID();
        colID.setCellValueFactory(new TreeItemPropertyValueFactory<>("cusid"));
        colName.setCellValueFactory(new TreeItemPropertyValueFactory<>("cusName"));
        colAddress.setCellValueFactory(new TreeItemPropertyValueFactory<>("cusAddress"));
        colSalary.setCellValueFactory(new TreeItemPropertyValueFactory<>("cusSalary"));
        loadCustomerTable();
    }

    private void loadCustomerTable() {

    }

    private void generateID() {

    }

    public void btnBackOnaction(ActionEvent actionEvent) {
        Stage stage = (Stage) CustomerPane.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/HomePage.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
    }
}
