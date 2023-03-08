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
        db.execSQL("create TABLE Pay (\n" +
                "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    type TEXT,\n" +
                "    transactiondate TEXT,\n" +
                "    FOREIGN KEY(expenseId) REFERENCES Expense(id)\n" +
                ");");
        db.execSQL("create TABLE Agreements(\n" +
                "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    Subject TEXT,\n" +
                "    Content TEXT,\n" +
                "    FOREIGN KEY(projectId) REFERENCES Project(id)\n" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
