package br.com.digitalaccount.account;

import br.com.digitalaccount.account.domain.Account;
import br.com.digitalaccount.account.service.AccountService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import java.util.List;
import java.util.Map;

@Path("/accounts")
public class AccountResource {

    @Inject
    private AccountService accountService;

    @GET
    public List<Account> findAllAccounts() {
        return accountService.listAccounts();
    }

    @POST
    public Account create(Account account){
        return accountService.newAccount(account);
    }
}
