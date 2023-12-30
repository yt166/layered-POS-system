package dao.custom.impl;

import dao.custom.ItemDao;
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
        String sql ="INSERT INTO Customer VALUE (?,?,?,?)";

        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement(sql);
        preparedStatement.setString(1, entity.getCode());
        preparedStatement.setString(2, entity.getDescription());
        preparedStatement.setDouble(3,entity.getUnitPrize());
        preparedStatement.setInt(4,entity.getQtyOnHand());

        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public boolean update(Item entity) throws SQLException, ClassNotFoundException {
        String sql ="UPDATE Customer SET description=?, unitPrice =?, qtyOnHand =?  WHERE id=?  ";
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement(sql);
        preparedStatement.setString(4,entity.getCode());
        preparedStatement.setString(1,entity.getDescription());
        preparedStatement.setDouble(2,entity.getUnitPrize());
        preparedStatement.setInt(3,entity.getQtyOnHand());

        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql="DELETE FROM item WHERE code =?";
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement(sql);
        preparedStatement.setString(1,id);

        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public List<Item> getAll() throws SQLException, ClassNotFoundException {
        List<Item> list = new ArrayList<>();
        String sql = "SELECT * FROM item";
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()) {
            list.add(new Item(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getInt(4)
            ));
        }
        return null;
    }
}
