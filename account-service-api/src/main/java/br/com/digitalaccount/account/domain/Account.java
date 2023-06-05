package br.com.digitalaccount.account.domain;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private Integer id;

    private Integer accountBranch;

    private Long accountNumber;

    private Double balance;

}
