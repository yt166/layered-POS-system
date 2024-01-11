package dto.tm;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.scene.control.Button;
import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderTm extends RecursiveTreeObject<OrderTm> {
    private String  code;
    private String description;
    private double unitPrice;
    private int qty;
    private Button btn;
}
