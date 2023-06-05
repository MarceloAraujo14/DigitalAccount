package br.com.digitalaccount.account.service;

import br.com.digitalaccount.account.domain.Account;

import java.util.List;

public interface AccountService {

    Account newAccount(Account account);

    Account updateAccount(Integer accountId, Account account);

    List<Account> listAccounts();
}
