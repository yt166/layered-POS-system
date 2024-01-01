package dao.custom.impl;

import dao.custom.OrderDao;
import db.DBConnection;
import dto.OrderDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDaoImpl implements OrderDao {

    @Override
    public boolean saveOrder(OrderDto orderdto) {
        String sql ="INSERT INTO orders VALUE (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,orderdto.getOrderID());
        preparedStatement.setString(2,orderdto.getDate());
        preparedStatement.setString(3,orderdto.getCusID());

        if(preparedStatement.executeUpdate()>0){
            boolean saved = orderDetailsModel.saveOrderDetails(orderdto.getList());
            if(saved){
                connection.commit();
                return true;
            }
        }
        return false;
    }

    @Override
    public OrderDto lastOrder() throws SQLException, ClassNotFoundException {
        String sql ="SELECT*FROM orders ORDER BY id DESC LIMIT 1";
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ResultSet set = preparedStatement.executeQuery();

        if(set.next()){
            return new OrderDto(
                    set.getString(1),set.getString(2),set.getString(3),null
            );
        }
        return null;
    }
}
