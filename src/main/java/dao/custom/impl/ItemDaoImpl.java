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
    public boolean addItem(Item dto) throws SQLException, ClassNotFoundException {
        String sql ="INSERT INTO Customer VALUE (?,?,?,?)";

        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement(sql);
        preparedStatement.setString(1, dto.getCode());
        preparedStatement.setString(2, dto.getDescription());
        preparedStatement.setDouble(3,dto.getUnitPrize());
        preparedStatement.setInt(4,dto.getQtyOnHand());

        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public boolean updateItem(Item dto) throws SQLException, ClassNotFoundException {
        String sql ="UPDATE Customer SET description=?, unitPrice =?, qtyOnHand =?  WHERE id=?  ";
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement(sql);
        preparedStatement.setString(4,dto.getCode());
        preparedStatement.setString(1,dto.getDescription());
        preparedStatement.setDouble(2,dto.getUnitPrize());
        preparedStatement.setInt(3,dto.getQtyOnHand());

        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public boolean deleteItem(String itemCode) throws SQLException, ClassNotFoundException {
        String sql="DELETE FROM item WHERE code =?";
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement(sql);
        preparedStatement.setString(1,itemCode);

        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public ItemDto getItem(String itemCode) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM item WHERE code=?";
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setString(1,itemCode);
        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()){
            return new ItemDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getInt(4)
            );
        }
        return null;
    }

    @Override
    public List<Item> allItem() throws SQLException, ClassNotFoundException {
        List<ItemDto> list = new ArrayList<>();
        String sql = "SELECT * FROM item";
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()){
            list.add(new ItemDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getInt(4)
            ));
        }
        return null;
    }

    @Override
    public ItemDto lastItem() throws SQLException, ClassNotFoundException {
        String sql ="SELECT * FROM item ORDER BY code DESC LIMIT 1";
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ResultSet set = preparedStatement.executeQuery();

        if(set.next()){
            return new ItemDto(set.getString(1),
                    set.getString(2),
                    set.getDouble(3),
                    set.getInt(4));
        }
        return null;
    }
}
