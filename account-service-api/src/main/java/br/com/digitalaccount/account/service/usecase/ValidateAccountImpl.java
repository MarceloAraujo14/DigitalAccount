package br.com.digitalaccount.account.service.usecase;

import br.com.digitalaccount.account.domain.Account;
import br.com.digitalaccount.account.service.usecase.interfaces.ValidateAccount;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Default;

@ApplicationScoped
public class ValidateAccountImpl implements ValidateAccount {

    @Override
    public Account execute(Account account) {
        return account;
    }
}
