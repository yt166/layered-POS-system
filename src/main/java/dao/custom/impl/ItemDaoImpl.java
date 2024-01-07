package dao.custom.impl;

import dao.custom.ItemDao;
import dao.util.CrudUtil;
import db.DBConnection;
import dto.ItemDto;
import entity.Item;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl implements ItemDao {
    @Override
    public boolean save(Item entity) throws SQLException, ClassNotFoundException {
        String sql ="INSERT INTO item VALUE (?,?,?,?)";

        return CrudUtil.execute(sql,entity.getCode(),entity.getDescription(),entity.getUnitPrize(),entity.getQtyOnHand());
    }

    @Override
    public boolean update(Item entity) throws SQLException, ClassNotFoundException {
        String sql ="UPDATE item SET description=?, unitPrice =?, qtyOnHand =?  WHERE code=?  ";

        return CrudUtil.execute(sql,entity.getDescription(),entity.getUnitPrize(),entity.getQtyOnHand(),entity.getCode());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql="DELETE FROM item WHERE code =?";

        return CrudUtil.execute(sql,id);
    }

    @Override
    public List<Item> getAll() throws SQLException, ClassNotFoundException {
        List<Item> list = new ArrayList<>();
        String sql = "SELECT * FROM item";
        ResultSet resultSet = CrudUtil.execute(sql);
        while (resultSet.next()) {
            list.add(new Item(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getInt(4)
            ));
        }
        return list;
    }
}
