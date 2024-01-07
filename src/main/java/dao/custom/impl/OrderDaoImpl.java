package dao.custom.impl;

import dao.custom.OrderDao;
import dao.util.CrudUtil;
import db.DBConnection;
import dto.OrderDto;
import entity.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDaoImpl implements OrderDao {

    @Override
    public boolean saveOrder(Orders orders) throws SQLException, ClassNotFoundException {
        String sql ="INSERT INTO orders VALUE (?,?,?)";
        return CrudUtil.execute(sql,orders.getOrderID(),orders.getCustomerID(),orders.getDate());
    }

    @Override
    public Orders lastOrder() throws SQLException, ClassNotFoundException {
        String sql ="SELECT*FROM orders ORDER BY id DESC LIMIT 1";
        return null;
    }

}
