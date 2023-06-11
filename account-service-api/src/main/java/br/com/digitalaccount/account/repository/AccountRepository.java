package br.com.digitalaccount.account.repository;

import br.com.digitalaccount.account.domain.Account;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {

    Account save(Account account);

    Account findById(Integer id);
    List<Account> listAll();

    Optional<Account> findByAccountBranchAndAccountNumber(Integer accountBranch, Long accountNumber);
}
