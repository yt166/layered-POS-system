package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePageCOntroller {
    public AnchorPane HomePane;
    public JFXButton btnCustomer;
    public JFXButton btnItem;
    public JFXButton btnPlaceOrder;
    public JFXButton btnOrderDetails;

    public void btnCustomerOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) HomePane.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/Customer.fxml"))));
            stage.setTitle("Customer Page");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnItemOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) HomePane.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/Item.fxml"))));
            stage.setTitle("Items Page ");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnPlaceOrderOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) HomePane.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/PlaceOrder.fxml"))));
            stage.setTitle("Place Order Page");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnOrderDetailsOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) HomePane.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/OrderDetails.fxml"))));
            stage.setTitle("Order Details Page");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
