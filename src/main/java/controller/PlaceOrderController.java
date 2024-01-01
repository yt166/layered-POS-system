package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

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
