package com.chocopay.registration.service.account;

import com.chocopay.registration.base.entity.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AccountMangerService {

    private final AccountManager accountManager;

    @Autowired
    public AccountMangerService(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public Account saveAccount(Account account) {
        return accountManager.save(account);
    }

    public Account getAccount(Long accountId) {
        return accountManager.getAccount(accountId);
    }

    public boolean removeAccount(Long accountId) {
        accountManager.removeAccount(accountId);
        return true;
    }

    public List<Account> getAllAccount() {
        return accountManager.getAllAccount();
    }
}
