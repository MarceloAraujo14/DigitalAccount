package br.com.digitalaccount.account.service.usecase.interfaces;

import br.com.digitalaccount.account.domain.Account;

public interface ValidateAccount {

    Account execute(Account account);
}
