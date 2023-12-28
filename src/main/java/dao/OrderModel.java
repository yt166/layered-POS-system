package dao;

import dto.OrderDto;

import java.sql.SQLException;

public interface OrderModel {
    boolean saveOrder(OrderDto orderdto);
    OrderDto lastOrder() throws SQLException, ClassNotFoundException;
}
