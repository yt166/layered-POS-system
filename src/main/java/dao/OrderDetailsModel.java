package dao;

import controller.OrderDetailsController;
import dto.OrderDetailDto;

import java.sql.SQLException;
import java.util.List;

public interface OrderDetailsModel {
    boolean saveOrderDetails(List<OrderDetailDto> list) throws SQLException, ClassNotFoundException;

}
