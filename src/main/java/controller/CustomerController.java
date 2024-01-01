package controller;

import bo.BoFactory;
import bo.custom.CustomerBo;
import bo.custom.impl.CustomerBoImpl;
import com.jfoenix.controls.*;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import dao.util.BoType;
import dto.CustomerDto;
import dto.tm.CustomerTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    public JFXTreeTableView<CustomerTm> tblCustomer;
    public TreeTableColumn colID;
    public TreeTableColumn colName;
    public TreeTableColumn colAddress;
    public TreeTableColumn colSalary;
    public JFXButton btnDelete;
    public JFXTextField txtUpdateSalary;
    CustomerBo customerBo = BoFactory.getInstance().getBo(BoType.CUSTOMER);
    private List<CustomerDto> customers;

    public void initialize(){
        generateID();
        colID.setCellValueFactory(new TreeItemPropertyValueFactory<>("id"));
        colName.setCellValueFactory(new TreeItemPropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new TreeItemPropertyValueFactory<>("address"));
        colSalary.setCellValueFactory(new TreeItemPropertyValueFactory<>("salary"));
        loadCustomerTable();
        loadCustomerID();

        cmbCustomerID.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, id) ->{
            for (CustomerDto customerdto:customers) {
                if(customerdto.getId().equals(id)){
                    txtUpdateName.setText(customerdto.getName());
                    txtUpdateAddress.setText(customerdto.getAddress());
                    txtUpdateSalary.setText(String.format("%.2f",customerdto.getSalary()));
                }
            }
        } );
    }

    private void loadCustomerID() {
            try {
                customers = customerBo.allCustomer();
                ObservableList list =FXCollections.observableArrayList();
                for(CustomerDto customerdto : customers){
                    list.add(customerdto.getId());
                }
                cmbCustomerID.setItems(list);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
    }

    private void loadCustomerTable() {
        ObservableList<CustomerTm> list = FXCollections.observableArrayList();
        try {
            List<CustomerDto> dtolist = customerBo.allCustomer();

            for (CustomerDto dto: dtolist) {

                CustomerTm ctm = new CustomerTm(
                        dto.getId(),
                        dto.getName(),
                        dto.getAddress(),
                        dto.getSalary()
                );
                list.add(ctm);
            }

            TreeItem<CustomerTm> treeItem = new RecursiveTreeItem<>(list, RecursiveTreeObject::getChildren);
            tblCustomer.setRoot(treeItem);
            tblCustomer.setShowRoot(false);

        } catch (SQLException |ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void setData(CustomerTm newValue) {
        if(newValue!=null){
            lblGenID.setText(newValue.getId());
            txtName.setText(newValue.getName());
            txtAddress.setText(newValue.getAddress());
            txtSalary.setText(String.valueOf(newValue.getSalary()));
        }
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
        try {
            boolean isSaved = customerBo.saveCustomer(new CustomerDto(lblGenID.getText(), txtName.getText(), txtAddress.getText(), Double.parseDouble(txtSalary.getText())));

            if(isSaved){
                new Alert(Alert.AlertType.INFORMATION,"Customer Saved Successfully").show();
                loadCustomerTable();
                clearFields();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        try {
            boolean updated = customerBo.updateCustomer(new CustomerDto(cmbCustomerID.getValue().toString(),
                    txtUpdateName.getText(),
                    txtUpdateAddress.getText(),
                    Double.parseDouble(txtUpdateSalary.getText())
            ));

            if(updated){
                new Alert(Alert.AlertType.INFORMATION,"Customer Updated").show();
                loadCustomerTable();
                clearFields();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        try {
            boolean deleted = customerBo.deleteCustomer(cmbCustomerID.getValue().toString());

            if(deleted){
                new Alert(Alert.AlertType.INFORMATION,"Customer Deleted Successfully").show();
                loadCustomerTable();
                clearFields();
            }else{
                new Alert(Alert.AlertType.INFORMATION,"Something Wents Wrong").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void clearFields() {
        txtAddress.clear();
        txtSalary.clear();
        txtName.clear();
        txtUpdateName.clear();
        txtUpdateAddress.clear();
        txtUpdateSalary.clear();
    }
}
