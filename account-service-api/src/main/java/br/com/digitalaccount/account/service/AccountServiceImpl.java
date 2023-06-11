package br.com.digitalaccount.account.service;

import br.com.digitalaccount.account.domain.Account;
import br.com.digitalaccount.account.repository.AccountRepositoryImpl;
import br.com.digitalaccount.account.service.usecase.interfaces.ValidateAccount;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.val;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class AccountServiceImpl implements AccountService {

    @Inject
    private AccountRepositoryImpl accountRepository;

    @Inject
    private ValidateAccount validateAccount;

    @Override
    public Account newAccount(Account account) {
        validateAccount.execute(account);
        account.setDatCreation(LocalDateTime.now());
        return accountRepository.save(account);
    }

    @Override
    public Account updateAccount(Integer accountId,Account account) {
        val accountToUpdate = accountRepository.findById(accountId);
        accountToUpdate.setBalance(account.getBalance());
        accountToUpdate.setDatUpdate(LocalDateTime.now());
        return accountRepository.save(accountToUpdate);
    }

    @Override
    public List<Account> listAccounts() {
        return accountRepository.listAll();
    }
}
