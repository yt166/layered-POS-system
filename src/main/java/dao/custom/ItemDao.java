package dao.custom;

import dto.ItemDto;

import java.sql.SQLException;
import java.util.List;

public interface ItemDao {
    boolean addItem(ItemDto dto) throws SQLException, ClassNotFoundException;
    boolean updateItem(ItemDto dto) throws SQLException, ClassNotFoundException;

    boolean deleteItem(String itemCode) throws SQLException, ClassNotFoundException;

    ItemDto getItem(String itemCode) throws SQLException, ClassNotFoundException;
    List<ItemDto> allItem() throws SQLException, ClassNotFoundException;
    ItemDto lastItem() throws SQLException, ClassNotFoundException;
}
