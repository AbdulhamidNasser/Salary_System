package com.codeline.sampleProject.Service;

import com.codeline.sampleProject.Models.Account;
import com.codeline.sampleProject.Repository.AccountRepository;
import com.codeline.sampleProject.ResponseObject.GetAccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    public List<Account> getAccount() {
        return accountRepository.findAll();
    }

    @Autowired
    AccountRepository accountRepository;

    public void saveAccount(Account account) {
        accountRepository.save(account);
    }

    public GetAccountResponse getAccountById(Long AccountId) {
        Optional<Account> optionalAccount = accountRepository.findById(AccountId);
        if (!optionalAccount.isEmpty()) {
            Account account = optionalAccount.get();
            GetAccountResponse accountResponse = new GetAccountResponse(account.getBANK_NAME(), account.getAaccount_Number(), account.getBranch());
            return accountResponse;
        } else {
            return null;
        }
    }
}

