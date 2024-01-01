package bo.custom;

import bo.SuperBo;
import dto.OrderDto;

public interface OrderBo extends SuperBo {
    boolean saveOrder(OrderDto dto);
    String generateId();
}
