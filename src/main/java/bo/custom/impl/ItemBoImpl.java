package bo.custom.impl;

import bo.custom.ItemBo;
import dao.custom.ItemDao;
import dao.custom.impl.ItemDaoImpl;
import dto.CustomerDto;
import dto.ItemDto;
import entity.Customer;
import entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemBoImpl implements ItemBo<ItemDto> {
    ItemDao itemDao = new ItemDaoImpl();

    @Override
    public boolean addItem(ItemDto dto) throws SQLException, ClassNotFoundException {
        return itemDao.save(new Item(
                dto.getCode(),
                dto.getDescription(),
                dto.getUnitPrize(),
                dto.getQtyOnHand()
        ));
    }

    @Override
    public boolean updateItem(ItemDto dto) throws SQLException, ClassNotFoundException {
        return itemDao.update(new Item(
                dto.getCode(),
                dto.getDescription(),
                dto.getUnitPrize(),
                dto.getQtyOnHand()
        ));
    }

    @Override
    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException {

        return itemDao.delete(code);
    }

    @Override
    public List<ItemDto> allItems() throws SQLException, ClassNotFoundException {
       List<Item> entityList = itemDao.getAll();
       List<ItemDto> dtoList = new ArrayList<>();


            for (Item item : entityList) {
                dtoList.add(new ItemDto(
                        item.getCode(),
                        item.getDescription(),
                        item.getUnitPrize(),
                        item.getQtyOnHand()
                ));

            }

       return dtoList;
    }
}
