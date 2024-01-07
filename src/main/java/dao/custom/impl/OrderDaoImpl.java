package dao.custom.impl;

import dao.custom.OrderDao;
import dao.util.CrudUtil;
import dao.util.HibernateUtil;
import db.DBConnection;
import dto.OrderDetailDto;
import dto.OrderDto;
import entity.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    @Override
    public boolean saveOrder(OrderDto orderDto) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Orders order = new Orders(
                orderDto.getOrderID(),
                orderDto.getCustomerID(),
                orderDto.getDate()
        );
        order.setCustomer(session.find(Customer.class,orderDto.getCustomerID()));
        session.save(order);

        List<OrderDetailDto> list = orderDto.getList(); //dto type

        for (OrderDetailDto detailDto:list) {
            OrderDetails orderDetail = new OrderDetails(
                    new OrderDetailsKey(detailDto.getOrderId(), detailDto.getItemCode()),
                    session.find(Item.class, detailDto.getItemCode()),
                    order,
                    detailDto.getQty(),
                    detailDto.getUnitPrize()
            );
            session.save(orderDetail);
        }

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Orders lastOrder() throws SQLException, ClassNotFoundException {
        String sql ="SELECT*FROM orders ORDER BY id DESC LIMIT 1";
        return null;
    }

}
