package dao.custom;

import dto.OrderDto;
import entity.Orders;

import java.sql.SQLException;

public interface OrderDao {
    boolean saveOrder(OrderDto orderDto) throws SQLException, ClassNotFoundException;
    Orders lastOrder() throws SQLException, ClassNotFoundException;
}
