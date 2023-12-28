package dao;

import dto.CustomerDto;

import java.sql.SQLException;
import java.util.List;

public interface CustomerModel {
    boolean saveCustomer(CustomerDto cdto) throws SQLException, ClassNotFoundException;
    boolean updateCustomer(CustomerDto cdto) throws SQLException, ClassNotFoundException;
    boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;
    List<CustomerDto> allCustomers() throws SQLException, ClassNotFoundException;
    CustomerDto searchCustomer(String id);
    CustomerDto lastCustomer() throws SQLException, ClassNotFoundException;
}
