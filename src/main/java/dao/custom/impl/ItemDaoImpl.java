package dao.custom.impl;

import dao.custom.ItemDao;
import dao.util.CrudUtil;
import dao.util.HibernateUtil;
import db.DBConnection;
import dto.ItemDto;
import entity.Customer;
import entity.Item;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl implements ItemDao {
    @Override
    public boolean save(Item entity) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Item entity) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSession();

        Transaction transaction = session.beginTransaction();
        Item item = session.find(Item.class, entity.getCode());
        item.setDescription(entity.getDescription());
        item.setUnitPrize(entity.getUnitPrize());
        item.setQtyOnHand(entity.getQtyOnHand());
        session.save(item);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.find(Item.class,id));
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Item> getAll() throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("FROM Item ");
        List<Item> list = query.list();
        session.close();
        return list;
    }
}
