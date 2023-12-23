package entity;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private String code;
    private String description;
    private double unitPrize;
    private int qtyOnHand;
}
