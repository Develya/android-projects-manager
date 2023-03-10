package dev.paintilya.android_projects_manager.DAL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import dev.paintilya.android_projects_manager.DL.SQLiteHelper;
import dev.paintilya.android_projects_manager.Model.Agreement;
import dev.paintilya.android_projects_manager.Model.Expense;

public class ExpenseSQLiteDAO implements IExpenseDAO {
    private SQLiteHelper helper;

    public ExpenseSQLiteDAO(Context context) { this.helper = new SQLiteHelper(context); }


    @Override
    public int addExpense(Expense newExpense) {
        SQLiteDatabase db = this.helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("projectId", newExpense.getProjectId());
        values.put("name", newExpense.getName());
        values.put("amount", newExpense.getAmount());
        db.insert("Expense", "projectId, name, amount", values);
        db.close();
        return 0; // success
    }

    @Override
    public List<Expense> getAllExpensesByProjectId(int projectId) {
        SQLiteDatabase db = this.helper.getReadableDatabase();
        String request = "SELECT * FROM Expense WHERE projectId = ?";
        Cursor cursor = db.rawQuery(request, new String[] { ""+projectId });

        if (cursor != null) {
            cursor.moveToFirst();
            List<Expense> expenses = new ArrayList<>();
            while (!cursor.isAfterLast()) {
                Expense expense = new Expense();
                expense.setId(cursor.getInt(0));
                expense.setProjectId(cursor.getInt(1));
                expense.setName(cursor.getString(2));
                expense.setAmount(cursor.getDouble(3));
                expenses.add(expense);
                cursor.moveToNext();
            }
            db.close();
            return expenses;
        }
        return null;
    }

    @Override
    public int updateExpenseAmountById(int id, double amount) {
        SQLiteDatabase db = this.helper.getWritableDatabase();
        ContentValues values =  new ContentValues();
        values.put("amount", amount);
        db.update("Expense", values, "id = ?", new String[] { ""+id });
        return 0; // success
    }

    @Override
    public int deleteExpenseById(int id) {
        SQLiteDatabase db = this.helper.getWritableDatabase();
        db.delete("Expense", "id = ?", new String[] { ""+id });
        return 0;
    }
}
