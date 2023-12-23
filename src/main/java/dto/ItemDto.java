package dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ItemDto {
    private String code;
    private String description;
    private double unitPrize;
    private int qtyOnHand;
}
