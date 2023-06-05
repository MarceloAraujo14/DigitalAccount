package br.com.digitalaccount.account.service;

import br.com.digitalaccount.account.domain.Account;
import br.com.digitalaccount.account.repository.AccountRepositoryImpl;
import br.com.digitalaccount.account.service.usecase.interfaces.ValidateAccount;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class AccountServiceImpl implements AccountService {

    @Inject
    private AccountRepositoryImpl accountRepository;

    @Inject
    private ValidateAccount validateAccount;

    @Override
    public Account newAccount(Account account) {
        validateAccount.execute(account);
        return accountRepository.save(account);
    }

    @Override
    public Account updateAccount(Integer accountId,Account account) {
        Account accountToUpdate = accountRepository.findById(accountId);

        accountToUpdate.setBalance(account.getBalance());

        return accountRepository.save(accountToUpdate);
    }

    @Override
    public List<Account> listAccounts() {
        return accountRepository.listAll();
    }
}
