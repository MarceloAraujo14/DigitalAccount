package br.com.digitalaccount.account.repository;

import br.com.digitalaccount.account.domain.Account;

import java.util.List;

public interface AccountRepository {

    Account save(Account account);

    Account findById(Integer id);
    List<Account> listAll();
}
