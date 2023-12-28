package dao.custom.impl;

import dao.custom.OrderDao;
import dto.OrderDto;

import java.sql.SQLException;

public class OrderDaoImpl implements OrderDao {

    @Override
    public boolean saveOrder(OrderDto orderdto) {
        return false;
    }

    @Override
    public OrderDto lastOrder() throws SQLException, ClassNotFoundException {
        return null;
    }
}
