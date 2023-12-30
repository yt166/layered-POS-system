package dao.custom;

import dto.ItemDto;
import entity.Item;

import java.sql.SQLException;
import java.util.List;

public interface ItemDao {
    boolean addItem(Item dto) throws SQLException, ClassNotFoundException;
    boolean updateItem(Item dto) throws SQLException, ClassNotFoundException;

    boolean deleteItem(String itemCode) throws SQLException, ClassNotFoundException;

    ItemDto getItem(String itemCode) throws SQLException, ClassNotFoundException;
    List<Item> allItem() throws SQLException, ClassNotFoundException;
    ItemDto lastItem() throws SQLException, ClassNotFoundException;
}
