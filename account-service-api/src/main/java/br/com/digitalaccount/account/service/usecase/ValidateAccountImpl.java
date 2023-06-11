package br.com.digitalaccount.account.service.usecase;

import br.com.digitalaccount.account.domain.Account;
import br.com.digitalaccount.account.domain.exception.DuplicatedAccountException;
import br.com.digitalaccount.account.repository.AccountRepositoryImpl;
import br.com.digitalaccount.account.service.usecase.interfaces.ValidateAccount;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;

@ApplicationScoped
public class ValidateAccountImpl implements ValidateAccount {

    @Inject
    private AccountRepositoryImpl accountRepository;

    @Override
    public Account execute(Account account) {
        Optional<Account> duplicatedAccount = accountRepository.findByAccountBranchAndAccountNumber(account.getAccountBranch(), account.getAccountNumber());
        if (duplicatedAccount.isPresent()) throw new DuplicatedAccountException();
        return account;
    }
}
