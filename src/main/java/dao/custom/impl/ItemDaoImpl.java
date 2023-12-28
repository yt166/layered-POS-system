package dao.custom.impl;

import dao.custom.ItemDao;
import dto.ItemDto;

import java.sql.SQLException;
import java.util.List;

public class ItemDaoImpl implements ItemDao {
    @Override
    public boolean addItem(ItemDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updateItem(ItemDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean deleteItem(String itemCode) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ItemDto getItem(String itemCode) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<ItemDto> allItem() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ItemDto lastItem() throws SQLException, ClassNotFoundException {
        return null;
    }
}
