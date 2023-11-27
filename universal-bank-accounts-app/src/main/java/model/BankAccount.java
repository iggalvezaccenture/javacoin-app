package model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class BankAccount {

    private Long number;

    private BigDecimal amount;

}
