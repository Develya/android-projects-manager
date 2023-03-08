package dev.paintilya.android_projects_manager.DAL;

import java.util.List;

import dev.paintilya.android_projects_manager.Model.BankAccount;

public interface IBankAccountDAO {
    /*
        CRUD
    */

    // Create
    // Not needed

    // Read
    public List<BankAccount> getAllAccounts();

    // Update
    public int updateBankAccountBalanceById(int id, double newBalance);

    // Delete
    // Not needed
}
