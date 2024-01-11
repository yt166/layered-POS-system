package controller;

import bo.BoFactory;
import bo.custom.CustomerBo;
import bo.custom.ItemBo;
import bo.custom.OrderBo;
import com.jfoenix.controls.*;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import dao.util.BoType;
import dto.CustomerDto;
import dto.ItemDto;
import dto.OrderDto;
import dto.tm.OrderTm;
import entity.OrderDetails;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
    public JFXTreeTableView <OrderTm>tblOrders;
    private List<CustomerDto> customers;
    private List<ItemDto> items;
    private ItemBo itemBo = BoFactory.getInstance().getBo(BoType.ITEM);
    private CustomerBo customerBo = BoFactory.getInstance().getBo(BoType.CUSTOMER);
    private OrderBo orderBo = BoFactory.getInstance().getBo(BoType.ORDER);
    private  ObservableList<OrderTm> tmlist = FXCollections.observableArrayList();
    private double amount = 0.0;

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
       /* try {
            double prize = itemBo.allItems(cmbItems.getValue().toString()).getUnitPrize()*Integer.parseInt(txtQtyOnHand.getText());
            JFXButton btn = new JFXButton("Delete");

            OrderTm orderTm = new OrderTm(
                    cmbItems.getValue().toString(),
                    txtDescription.getText(),
                    Integer.parseInt(txtQtyOnHand.getText()),
                    prize,
                    btn
            );

            btn.setOnAction(actionEvent1 -> {
                tmlist.remove(orderTm);
                amount -= orderTm.getUnitPrice();
                tblOrders.refresh();
                lblSetAmount.setText(String.format("%.2f",amount));
            });

            boolean isExist = false;
            for(OrderTm order: tmlist){
                if(order.getCode().equals(orderTm.getCode())){
                    order.setQty(order.getQty()+orderTm.getQty());
                    order.setPrize(order.getPrize()+orderTm.getPrize());
                    isExist = true;
                    amount+=orderTm.getPrize();
                }
            }

            if(!isExist){
                tmlist.add(orderTm);
                amount+=orderTm.getUnitPrice();
            }

            TreeItem<OrderTm> treeItem = new RecursiveTreeItem<>(tmlist, RecursiveTreeObject::getChildren);
            tblOrders.setRoot(treeItem);
            tblOrders.setShowRoot(false);

            txtQtyOnHand.clear();
            lblAmount.setText(String.format("%.2f",amount));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }*/
    }

    public void btnPlaceOrderOnAction(ActionEvent actionEvent) {
        /*List<OrderDetails> list = new ArrayList<>();
        for (OrderTm orderTm:tmlist) {
            list.add(new OrderDetails(
                    lblGenID.getText(),
                    orderTm.getCode(),
                    orderTm.getQty(),
                    orderTm.getPrize()/orderTm.getQty()
            ));
        }
        boolean isSaved = false;
        isSaved = orderBo.saveOrder(new OrderDto(
                lblAmount.getText(),
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd")),
                cmbCusID.getValue().toString(),
                list
           }
    }*/
    }
}
