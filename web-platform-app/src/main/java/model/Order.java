package model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class Order  implements Serializable {
    private  UUID orderUUID;
    private  BigDecimal amount;
    private  BigDecimal price;
    private  String bidderUsername;
    private  String offereeUsername;
}
