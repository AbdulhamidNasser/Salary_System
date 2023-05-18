package com.codeline.sampleProject.Controller;

import com.codeline.sampleProject.Models.Account;
import com.codeline.sampleProject.ResponseObject.GetAccountResponse;
import com.codeline.sampleProject.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class AccountController {


    @Autowired
    AccountService accountService;

    @RequestMapping("Account/create")
    public void saveAccount()
    {
        createAccount();
    }

    @RequestMapping("account/get")
    public List<Account> getAccount ()
    {
        return accountService.getAccount();
    }

    @RequestMapping("account/get/{accountId}")
    public GetAccountResponse createAccount (@PathVariable Long accountId)
    {
        return accountService.getAccountById(accountId);
    }

    public void createAccount() {

        Account account = new Account();
        account.setBANK_NAME("Nizwa");
        account.setAaccount_Number(48484848);
        account.setHolder_Name("Hamid");
        account.setCreated_Date(new Date());
        account.setBranch_Code(99999);
        account.setSwift_Code("00011");
        account.setBranch("Sumail");
        accountService.saveAccount(account);
    }
}
