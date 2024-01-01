package controller;

import bo.BoFactory;
import bo.custom.CustomerBo;
import bo.custom.ItemBo;
import bo.custom.OrderBo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dao.util.BoType;
import dto.CustomerDto;
import dto.ItemDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class PlaceOrderController {
    public AnchorPane PlaceOrderPane;
    public JFXButton btnBack;
    public JFXComboBox cmbCusID;
    public JFXTextField txtName;
    public JFXTextField txtDescription;
    public JFXTextField txtUnitPrize;
    public JFXTextField txtQtyOnHand;
    public JFXComboBox cmbItems;
    public TreeTableColumn colCode;
    public TreeTableColumn colDescription;
    public TreeTableColumn colUnitPrize;
    public TreeTableColumn colQty;
    public TreeTableColumn colOption;
    public JFXButton btnAddToCart;
    public JFXButton btnPlaceOrder;
    public Label lblAmount;
    public TreeTableColumn colAmount;
    private List<CustomerDto> customers;
    private List<ItemDto> items;
    private ItemBo itemBo = BoFactory.getInstance().getBo(BoType.ITEM);
    private CustomerBo customerBo = BoFactory.getInstance().getBo(BoType.CUSTOMER);
    private OrderBo orderBo = BoFactory.getInstance().getBo(BoType.ORDER);

    public void initialize(){
        colCode.setCellValueFactory(new TreeItemPropertyValueFactory<>("code"));
        colDescription.setCellValueFactory(new TreeItemPropertyValueFactory<>("description"));
        colQty.setCellValueFactory(new TreeItemPropertyValueFactory<>("qty"));
        colAmount.setCellValueFactory(new TreeItemPropertyValueFactory<>("prize"));
        colOption.setCellValueFactory(new TreeItemPropertyValueFactory<>("btn"));

        generateID();
        loadCustomerID();
        loadItemCode();

        cmbCusID.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, id) ->{
            for (CustomerDto customerdto:customers) {
                if(customerdto.getId().equals(id)){
                    txtName.setText(customerdto.getName());
                }
            }
        } );

        cmbItems.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, code) ->{
            for(ItemDto itemdto : items){
                if(itemdto.getCode().equals(code)){
                    txtDescription.setText(itemdto.getDescription());
                    txtUnitPrize.setText(String.format("%.2f",itemdto.getUnitPrize()));
                }
            }
        } );
    }

    private void generateID() {
    }

    private void loadItemCode() {
        try {
            items = itemBo.allItems();
            ObservableList list = FXCollections.observableArrayList();
            for(ItemDto itemdto:items){
                list.add(itemdto.getCode());
            }
            cmbItems.setItems(list);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadCustomerID() {
        try {
            customers = customerBo.allCustomer();
            ObservableList list =FXCollections.observableArrayList();
            for(CustomerDto customerdto : customers){
                list.add(customerdto.getId());
            }
            cmbCusID.setItems(list);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnBackOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) PlaceOrderPane.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/HomePage.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnAddToCartOnAction(ActionEvent actionEvent) {
    }

    public void btnPlaceOrderOnAction(ActionEvent actionEvent) {
    }
}
