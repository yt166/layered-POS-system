package bo.custom;

import bo.SuperBo;
import dto.ItemDto;

import java.sql.SQLException;
import java.util.List;

public interface ItemBo<T> extends SuperBo {
    boolean addItem(T dto) throws SQLException, ClassNotFoundException;
    boolean updateItem(T dto) throws SQLException, ClassNotFoundException;
    boolean deleteItem(String code);
    List<ItemDto> allItems() throws SQLException, ClassNotFoundException;

}
