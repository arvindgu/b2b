package com.chocopay.registration.service.account;

import com.chocopay.registration.base.entity.Account;
import com.chocopay.registration.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class AccountManager {

    private final AccountDao accountDao;

    @Autowired
    public AccountManager(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Transactional
    public Account save(Account account) {
        return accountDao.save(account);
    }

    @Transactional(readOnly = true)
    public Account getAccount(Long accountId) {
        return accountDao.findById(accountId).orElse(null);
    }

    @Transactional
    public void removeAccount(Long accountId) {
        accountDao.deleteById(accountId);
    }

    @Transactional(readOnly = true)
    public List<Account> getAllAccount() {
        return accountDao.findAll();
    }
}
