package dev.paintilya.android_projects_manager.DAL;

import java.util.List;

import dev.paintilya.android_projects_manager.Model.Agreement;
import dev.paintilya.android_projects_manager.Model.BankAccount;
import dev.paintilya.android_projects_manager.Model.Expense;

public interface IExpenseDAO {
    /*
        CRUD
    */

    // Create
    public int addExpenseByProjectId(int projectId, Agreement newAgreement);

    // Read
    public List<Expense> getAllExpensesByProjectId(int projectId);

    // Update
    public int updateExpenseById(int id, double amount);

    // Delete
    public int deleteExpenseById(int id);

}
