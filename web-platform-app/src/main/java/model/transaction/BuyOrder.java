package model.transaction;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder(toBuilder = true)
@Data
public class BuyOrder extends Order {

    @Override
    public BigDecimal calculateTransactionAmount() {
        return BigDecimal.valueOf(-1).multiply(this.getAmount());
    }
}
