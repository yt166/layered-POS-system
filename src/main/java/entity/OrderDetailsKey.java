package entity;

import lombok.*;

import javax.persistence.Column;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderDetailsKey {
    @Column(name = "order_id")
    private String orderId;
    @Column(name = "item_code")
    private String itemCode;
}
