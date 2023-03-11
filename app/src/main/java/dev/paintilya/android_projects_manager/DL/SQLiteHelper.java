package dev.paintilya.android_projects_manager.DL;

import android.content.ContentValues;
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

        db.execSQL("INSERT INTO Project (name, startDate, endDate) VALUES ('Les Jardins Mercier', '2023-03-09', '2023-09-09');");
        db.execSQL("INSERT INTO Project (name, startDate, endDate) VALUES ('YUL Condominiums', '2023-09-09', '2024-09-09');");

        db.execSQL("INSERT INTO BankAccount (balance, name) VALUES (8535.55, 'BC1_RBC Scott');");
        db.execSQL("INSERT INTO BankAccount (balance, name) VALUES (2543.38, 'BC2_BN');");

        db.execSQL("INSERT INTO Expense (projectid, name, amount) VALUES (1, 'Fleurs', 540);");
        db.execSQL("INSERT INTO Expense (projectid, name, amount) VALUES (1, 'Terre', 250);");
        db.execSQL("INSERT INTO Expense (projectid, name, amount) VALUES (2, 'Plancher bois', 1057);");
        db.execSQL("INSERT INTO Expense (projectid, name, amount) VALUES (2, 'Meubles', 1809.95);");

        db.execSQL("INSERT INTO PaymentMethod (expenseId, bankAccountId, type, transactionDate) VALUES (1, 1, 'CHECK', '2023-03-11');");
        db.execSQL("INSERT INTO PaymentMethod (expenseId, bankAccountId, type, transactionDate) VALUES (4, 2, 'CHECK', '2023-03-11');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
