package dev.paintilya.android_projects_manager.DAL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import dev.paintilya.android_projects_manager.DL.SQLiteHelper;
import dev.paintilya.android_projects_manager.BLL.Model.BankAccount;

public class BankAccountSQLiteDAO implements IBankAccountDAO{

    SQLiteHelper helper;

    public BankAccountSQLiteDAO(Context context) {
        this.helper = new SQLiteHelper(context);
    }
    @Override
    public List<BankAccount> getAllBankAccounts() {
        SQLiteDatabase db = this.helper.getReadableDatabase();
        String request = "SELECT * FROM BankAccount";
        Cursor cursor = db.rawQuery(request, null);
        if (cursor != null) {
            cursor.moveToFirst();
            List<BankAccount> bankAccounts = new ArrayList<>();
            while (!cursor.isAfterLast()) {
                BankAccount bankAccount = new BankAccount();
                bankAccount.setId(cursor.getInt(0));
                bankAccount.setBalance(cursor.getDouble(1));
                bankAccount.setName(cursor.getString(2));
                bankAccounts.add(bankAccount);
                cursor.moveToNext();
            }
            cursor.close();
            db.close();
            return bankAccounts;
        }

        return null;
    }

    @Override
    public BankAccount getBankAccountById(int id) {
        SQLiteDatabase db = this.helper.getReadableDatabase();
        String request = "SELECT * FROM BankAccount WHERE id = ?";
        Cursor cursor = db.rawQuery(request, new String[]{""+id});
        if (cursor != null) {
            cursor.moveToFirst();
            BankAccount bankAccount = new BankAccount();
            while (!cursor.isAfterLast()) {
                bankAccount.setId(cursor.getInt(0));
                bankAccount.setBalance(cursor.getDouble(1));
                bankAccount.setName(cursor.getString(2));
                cursor.moveToNext();
            }
            cursor.close();
            db.close();
            return bankAccount;
        }

        return null;
    }

    @Override
    public double getBankAccountBalanceById(int id) {
        SQLiteDatabase db = this.helper.getReadableDatabase();
        String request = "SELECT balance FROM BankAccount WHERE id = ?";
        Cursor cursor = db.rawQuery(request, new String[]{""+id});
        if (cursor != null) {
            cursor.moveToFirst();
            double balance = 0.0;
            while (!cursor.isAfterLast()) {
                balance = cursor.getDouble(0);
                cursor.moveToNext();
            }
            cursor.close();
            db.close();
            return balance;
        }

        return -1; // error
    }

    @Override
    public int updateBankAccountBalanceById(int id, double newBalance) {
        SQLiteDatabase db = this.helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("balance", newBalance);
        db.update("BankAccount",  values, "id = ?", new String[]{ id+"" });
        return 0; //success
    }
}
