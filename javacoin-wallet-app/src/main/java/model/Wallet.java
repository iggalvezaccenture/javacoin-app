package model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class Wallet {
    private UUID walletId;
    private BigDecimal amount;
}
