package br.com.digitalaccount.account.repository;

import br.com.digitalaccount.account.domain.Account;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class AccountRepositoryImpl implements AccountRepository {

    private final List<Account> accounts = new ArrayList<>(
            List.of(
                    Account.builder()
                            .id(0)
                            .accountBranch(1)
                            .accountNumber(123456L)
                            .balance(500.00)
                            .build()));

    public Account save(Account account){
        account.setId(accounts.size());
        accounts.add(account);
        return account;
    }

    @Override
    public Account findById(Integer id) {
        return accounts.get(id);
    }

    public List<Account> listAll(){
        return accounts;
    }

}
