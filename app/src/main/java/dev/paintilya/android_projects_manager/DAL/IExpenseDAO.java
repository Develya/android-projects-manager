package dev.paintilya.android_projects_manager.DAL;

import java.util.List;

import dev.paintilya.android_projects_manager.BLL.Model.Expense;

public interface IExpenseDAO {
    /*
        CRUD
    */

    // Create
    public int addExpense(Expense newExpense);

    // Read
    public List<Expense> getAllExpensesByProjectId(int projectId);
    public List<Expense> getAllExpensesByBankAccountId(int projectId);

    // Update
    public int updateExpenseAmountById(int id, double amount);

    // Delete
    public int deleteExpenseById(int id);

}
