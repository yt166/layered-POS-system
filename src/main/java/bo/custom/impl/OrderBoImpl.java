package bo.custom.impl;

import bo.BoFactory;
import bo.custom.OrderBo;
import dao.DaoFactory;
import dao.custom.OrderDao;
import dao.util.DaoType;
import dto.OrderDto;
import entity.Orders;

import java.sql.SQLException;

public class OrderBoImpl implements OrderBo {
    private OrderDao orderDao = DaoFactory.getInstance().getDao(DaoType.ORDER);
    @Override
    public boolean saveOrder(OrderDto dto) throws SQLException, ClassNotFoundException {

        return orderDao.saveOrder(new Orders(dto.getOrderID(), dto.getCustomerID(),dto.getDate()));
    }

    @Override
    public String generateId() {
        return null;
    }
}
