package model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class User {

    private String DNI;

    private String username;

    private Wallet wallet;

}
