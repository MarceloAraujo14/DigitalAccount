package br.com.digitalaccount.account.domain;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private Integer id;

    private Integer accountBranch;

    private Long accountNumber;

    private Double balance;

    private LocalDateTime datCreation;

    private LocalDateTime datUpdate;

}
