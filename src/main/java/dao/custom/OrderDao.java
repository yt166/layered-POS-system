package dao.custom;

import dto.OrderDto;

import java.sql.SQLException;

public interface OrderDao {
    boolean saveOrder(OrderDto orderdto);
    OrderDto lastOrder() throws SQLException, ClassNotFoundException;
}
