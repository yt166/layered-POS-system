package controller;

import bo.custom.ItemBo;
import bo.custom.impl.ItemBoImpl;
import com.jfoenix.controls.*;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import dto.CustomerDto;
import dto.ItemDto;
import dto.tm.CustomerTm;
import dto.tm.ItemTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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

public class itemCotroller {
    public AnchorPane ItemPane;
    public JFXButton btnBack;
    public ImageView imgItem;
    public Label lblGenCode;
    public JFXTextField txtDescription;
    public JFXTextField txtUnitPrice;
    public JFXTextField txtQtyOnHand;
    public JFXButton btnAddItem;
    public JFXComboBox cmbItemCodes;
    public JFXTextField txtUpdateDescription;
    public JFXTextField txtUpdateUnitPrize;
    public JFXTextField txtUpdateQty;
    public TreeTableColumn colCode;
    public TreeTableColumn colDescription;
    public TreeTableColumn colUnitPrize;
    public TreeTableColumn colQty;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;
    public JFXTreeTableView <ItemTm>tblItem;
    private List<ItemDto> items;
    ItemBo<ItemDto> itemBo = new ItemBoImpl();

    public void initialize(){
        generateID();
        colCode.setCellValueFactory(new TreeItemPropertyValueFactory<>("code"));
        colDescription.setCellValueFactory(new TreeItemPropertyValueFactory<>("description"));
        colUnitPrize.setCellValueFactory(new TreeItemPropertyValueFactory<>("unitPrize"));
        colQty.setCellValueFactory(new TreeItemPropertyValueFactory<>("qtyOnHand"));
        loadItemTable();
        loadItemCodes();

        cmbItemCodes.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, code) ->{
            for (ItemDto itemDto:items) {
                if(itemDto.getCode().equals(code)){
                    txtUpdateDescription.setText(itemDto.getCode());
                    txtUpdateUnitPrize.setText(String.format("%.2f",itemDto.getUnitPrize()));
                    txtUpdateQty.setText(String.format("%.2f",itemDto.getQtyOnHand()));
                }
            }
        } );
    }

    private void loadItemCodes() {
        try {
            items = itemBo.allItems();
            ObservableList list = FXCollections.observableArrayList();
            for(ItemDto itemDto: items){
                list.add(itemDto.getCode());
            }
            cmbItemCodes.setItems(list);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private void loadItemTable() {
        ObservableList<ItemTm> list = FXCollections.observableArrayList();
        try {
            List<ItemDto> dtolist = itemBo.allItems();

            for (ItemDto itemDto: dtolist) {

                ItemTm tm = new ItemTm(
                        itemDto.getCode(),
                        itemDto.getDescription(),
                        itemDto.getUnitPrize(),
                        itemDto.getQtyOnHand()
                );
                list.add(tm);
            }

            TreeItem<ItemTm> treeItem = new RecursiveTreeItem<>(list, RecursiveTreeObject::getChildren);
            tblItem.setRoot(treeItem);
            tblItem.setShowRoot(false);

        } catch (SQLException |ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    private void generateID() {
    }

    public void btnBackOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) ItemPane.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/HomePage.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnAddItemOnAction(ActionEvent actionEvent) {
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
    }
}
