package model.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import model.enums.Status;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@SuperBuilder
public class Order implements Serializable {
    private final UUID orderUUID;
    private final BigDecimal amount;
    private final BigDecimal price;
    private final String bidderUsername;
    private Status status;
}
