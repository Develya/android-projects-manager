package dev.paintilya.android_projects_manager.DL;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {

    public SQLiteHelper(Context context) { super(context, "projects.db", null, 1); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /*
            DATABASE INIT
        */
        db.execSQL("CREATE TABLE BankAccount (\n" +
                "    id integer PRIMARY KEY AUTOINCREMENT,\n" +
                "    balance double NOT NULL,\n" +
                "    name text NOT NULL\n" +
                ");");
        db.execSQL("CREATE table Project (\n" +
                "\tid integer PRIMARY KEY AUTOINCREMENT,\n" +
                "  \tname text NOT NULL,\n" +
                "  \tstartDate text NOT NULL,\n" +
                "  \tendDate text NOT NULL\n" +
                ");");
        db.execSQL("create table Expense (\n" +
                "\tid integer PRIMARY KEY AUTOINCREMENT,\n" +
                "  \tprojectId integer NOT NULL,\n" +
                "  \tname text NOT NULL,\n" +
                "  \tamount double NOT NULL,\n" +
                "  \tFOREIGN KEY (projectId) REFERENCES Project(id)\n" +
                ");");
        db.execSQL("create TABLE PaymentMethod (\n" +
                "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    expenseId integer NOT NULL,\n" +
                "    bankAccountId integer NOT NULL, \n" +
                "    type TEXT NOT NULL,\n" +
                "    transactiondate TEXT NOT NULL,\n" +
                "    FOREIGN KEY(expenseId) REFERENCES Expense(id),\n" +
                "    FOREIGN KEY(bankAccountId) REFERENCES BankAccount(id)\n" +
                ");");
        db.execSQL("create TABLE Agreement(\n" +
                "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    projectId integer NOT NULL,\n" +
                "    Subject TEXT NOT NULL,\n" +
                "    Content TEXT NOT NULL,\n" +
                "    FOREIGN KEY(projectId) REFERENCES Project(id)\n" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
