package entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Orders {
    @Id
    private String orderID;
    private String date;
    private String customerID;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "orders")
    private List<OrderDetails> orderDetails = new ArrayList<>();

    public Orders(String orderID, String date, String customerID) {
        this.orderID = orderID;
        this.date = date;
        this.customerID = customerID;
    }
}
