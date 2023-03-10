package dev.paintilya.android_projects_manager.DAL;

import java.util.List;

import dev.paintilya.android_projects_manager.Model.BankAccount;

public class BankAccountSQLiteDAO implements IBankAccountDAO{
    @Override
    public List<BankAccount> getAllAccounts() {
        return null;
    }

    @Override
    public int updateBankAccountBalanceById(int id, double newBalance) {
        return 0;
    }
}
