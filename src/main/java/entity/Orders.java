package entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Orders {
    private String orderID;
    private String date;
    private String customerID;
}
