package model.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import model.transaction.enums.Status;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@SuperBuilder
public class Order  {
    private final UUID orderUUID;
    private final BigDecimal amount;
    private final BigDecimal price;
    private final String bidderUsername;
    private final String offereeDNI;
    private Status status;

}
