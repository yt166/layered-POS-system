package dao.custom.impl;

import dao.custom.OrderDetailsDao;
import dto.OrderDetailDto;

import java.sql.SQLException;
import java.util.List;

public class OrderDetailsDaoImpl implements OrderDetailsDao {
    @Override
    public boolean saveOrderDetails(List<OrderDetailDto> list) throws SQLException, ClassNotFoundException {
        return false;
    }
}
