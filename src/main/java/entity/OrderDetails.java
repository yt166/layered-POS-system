package entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class OrderDetails {
    private String orderID;
    private String itemCode;
    private int qty;
    private double unitPrize;
}
