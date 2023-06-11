package br.com.digitalaccount.transfer.domain;

import java.time.LocalDateTime;

public class Transfer {

    private Long id;
    private Integer accountFrom;
    private Integer branchFrom;
    private Integer accountTo;
    private Integer branchTo;
    private Double amount;
    private LocalDateTime datCreate;
    private LocalDateTime datUpdate;
    private TransferStatus status;

}
