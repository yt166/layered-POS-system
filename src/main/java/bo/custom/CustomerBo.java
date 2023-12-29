package bo.custom;

import bo.SuperBo;

import java.sql.SQLException;
import java.util.List;

public interface CustomerBo <T> extends SuperBo {
    boolean saveCustomer(T dto) throws SQLException, ClassNotFoundException;
    boolean updateCustomer(T dto);
    boolean deleteCustomer(String id);
    List<T> allCustomer();
}
