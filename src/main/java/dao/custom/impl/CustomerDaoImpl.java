package dao.custom.impl;

import dao.custom.CustomerDao;
import db.DBConnection;
import dto.CustomerDto;
import entity.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public boolean save(Customer entity) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO Customer VALUES(?,?,?,?)";
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement(sql);

        preparedStatement.setString(1, entity.getId());
        preparedStatement.setString(2, entity.getName());
        preparedStatement.setString(3, entity.getAddress());
        preparedStatement.setDouble(4, entity.getSalary());

        return preparedStatement.executeUpdate()>0;

    }

    @Override
    public boolean update(Customer entity) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Customer SET name=?, address=?, salary=? WHERE id=?";
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement(sql);

        preparedStatement.setString(1, entity.getName());
        preparedStatement.setString(2, entity.getAddress());
        preparedStatement.setDouble(3, entity.getSalary());
        preparedStatement.setString(4, entity.getId());

        return preparedStatement.executeUpdate()>0 ;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql ="DELETE FROM Customer WHERE id=?";
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement(sql);
        preparedStatement.setString(1,id);
        return preparedStatement.executeUpdate()>0;

    }

    @Override
    public List<Customer> getAll(Customer entity) throws SQLException, ClassNotFoundException {
        List<Customer> list = new ArrayList<>() ;
        String sql = "SELECT * FROM customer";
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ResultSet set = preparedStatement.executeQuery();
        while (set.next()){
            list.add(new Customer(
                    set.getString(1),
                    set.getString(2),
                    set.getString(3),
                    set.getDouble(4)
            ));
        }
        return list;
    }

    @Override
    public CustomerDto lastCustomer() throws SQLException, ClassNotFoundException {
        return null;
    }
}
