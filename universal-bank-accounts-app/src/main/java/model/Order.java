package model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class Order implements Serializable {
    private final UUID orderUUID;
    private final BigDecimal amount;
    private final BigDecimal price;
    private final String bidderUsername;
    private final String offereeUsername;
}
