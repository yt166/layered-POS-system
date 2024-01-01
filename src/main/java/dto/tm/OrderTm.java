package dto.tm;

import javafx.scene.control.Button;
import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderTm {
    private String  code;
    private String description;
    private double unitPrice;
    private int qty;
    private Button btn;
}
