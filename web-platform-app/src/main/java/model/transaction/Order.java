package model.transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import model.enums.OrderType;
import model.enums.Status;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@SuperBuilder
public abstract class Order  {
    private final UUID orderUUID;
    private final BigDecimal amount;
    private final BigDecimal price;
    private final String bidderUsername;
    private final String offereeUsername;
    private Status status;
    public abstract BigDecimal calculateTransactionAmount();
}
