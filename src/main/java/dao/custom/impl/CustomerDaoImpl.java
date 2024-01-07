package dao.custom.impl;

import dao.custom.CustomerDao;
import dao.util.CrudUtil;
import db.DBConnection;
import entity.Customer;

import javax.security.auth.login.Configuration;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public boolean save(Customer entity) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO Customer VALUES(?,?,?,?)";

        Configuration configuration = new Configuration().configure("");

        return CrudUtil.execute(sql,entity.getId(),entity.getName(),entity.getAddress(),entity.getSalary());
    }

    @Override
    public boolean update(Customer entity) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Customer SET name=?, address=?, salary=? WHERE id=?";

        return CrudUtil.execute(sql,entity.getName(),entity.getAddress(),entity.getSalary(),entity.getId());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql ="DELETE FROM Customer WHERE id=?";

        return CrudUtil.execute(sql,id);

    }


    @Override
    public List<Customer> getAll() throws SQLException, ClassNotFoundException {
        List<Customer> list = new ArrayList<>() ;
        String sql = "SELECT * FROM customer";
        ResultSet set = CrudUtil.execute(sql);
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

    public Customer lastCustomer() throws SQLException, ClassNotFoundException {
        String sql ="SELECT * FROM customer ORDER BY id DESC LIMIT 1";
        ResultSet set = CrudUtil.execute(sql);

        if(set.next()){
            return new Customer(set.getString(1),
                    set.getString(2),
                    set.getString(3),
                    set.getDouble(4));
        }
        return null;
    }
}
