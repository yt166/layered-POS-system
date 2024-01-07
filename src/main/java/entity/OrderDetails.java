package entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class OrderDetails {
    @Id
    private String orderID;
    private String itemCode;
    private int qty;
    private double unitPrize;
}
