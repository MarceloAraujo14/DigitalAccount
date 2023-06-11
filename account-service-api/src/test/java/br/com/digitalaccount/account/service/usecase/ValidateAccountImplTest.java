package br.com.digitalaccount.account.service.usecase;

import br.com.digitalaccount.account.domain.Account;
import br.com.digitalaccount.account.domain.exception.DuplicatedAccountException;
import br.com.digitalaccount.account.repository.AccountRepositoryImpl;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.Mockito.when;


@QuarkusTest
class ValidateAccountImplTest {

    @Inject
    ValidateAccountImpl validateAccount;
    @InjectMock
    AccountRepositoryImpl accountRepository;

    @Test
    void shouldThrowWhenDuplicatedAccountTest(){
        var account = buildAccount();
        Mockito.when(accountRepository.findByAccountBranchAndAccountNumber(1, 123456L)).thenReturn(Optional.of(account));
        Assertions.assertThrows(DuplicatedAccountException.class, () -> validateAccount.execute(account));
    }

    @Test
    void doNothingWhenValidAccount(){
        var account = buildAccount();
        Mockito.when(accountRepository.findByAccountBranchAndAccountNumber(1, 123454L)).thenReturn(Optional.empty());
        Assertions.assertDoesNotThrow(() -> validateAccount.execute(account));
    }

    private Account buildAccount(){
        return Account.builder()
                .id(0)
                .accountBranch(1)
                .accountNumber(123456L)
                .balance(500.00)
                .datCreation(LocalDateTime.of(2020,5,25,0,10))
                .build();
    }

}