package dev.paintilya.android_projects_manager.DL;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {

    public SQLiteHelper(Context context) { super(context, "projects.db", null, 1); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /*
            DATABASE INIT
        */
        db.execSQL("CREATE TABLE BankAccount (\n" +
                "   id integer PRIMARY KEY AUTOINCREMENT,\n" +
                "   balance double NOT NULL,\n" +
                "   name text NOT NULL\n" +
                ");");
        db.execSQL("CREATE table Project (\n" +
                "   id integer PRIMARY KEY AUTOINCREMENT,\n" +
                "   name text NOT NULL,\n" +
                "   startDate text NOT NULL,\n" +
                "   endDate text NOT NULL\n" +
                ");");
        db.execSQL("create table Expense (\n" +
                "   id integer PRIMARY KEY AUTOINCREMENT,\n" +
                "   bankAccountId integer NOT NULL,\n" +
                "   projectId integer NOT NULL,\n" +
                "   name text NOT NULL,\n" +
                "   amount double NOT NULL,\n" +
                "   date text NOT NULL,\n" +
                "   paymentType text NOT NULL,\n" +
                "   FOREIGN KEY (projectId) REFERENCES Project(id),\n" +
                "   FOREIGN KEY (bankAccountId) REFERENCES BankAccount(id)\n" +
                ");");
        db.execSQL("create TABLE Agreement(\n" +
                "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    projectId integer NOT NULL,\n" +
                "    subject TEXT NOT NULL,\n" +
                "    content TEXT NOT NULL,\n" +
                "    FOREIGN KEY(projectId) REFERENCES Project(id)\n" +
                ");");

        db.execSQL("INSERT INTO Project (name, startDate, endDate) VALUES ('Les Jardins Mercier', '2023-03-09', '2023-09-09');");
        db.execSQL("INSERT INTO Project (name, startDate, endDate) VALUES ('YUL Condominiums', '2023-09-09', '2024-09-09');");

        db.execSQL("INSERT INTO BankAccount (balance, name) VALUES (8535.55, 'BC1_RBC Scott');");
        db.execSQL("INSERT INTO BankAccount (balance, name) VALUES (2543.38, 'BC2_BN');");

        db.execSQL("INSERT INTO Expense (projectid, bankAccountId, name, amount, date, paymentType) VALUES (1, 1, 'Fleurs', 540.00, '2023-03-10', 'CHECK');");
        db.execSQL("INSERT INTO Expense (projectid, bankAccountId, name, amount, date, paymentType) VALUES (1, 1, 'Terre', 250.00, '2023-03-11', 'CREDIT');");
        db.execSQL("INSERT INTO Expense (projectid, bankAccountId, name, amount, date, paymentType) VALUES (2, 2, 'Fenêtres', 1057.00, '2023-03-16', 'CHECK');");
        db.execSQL("INSERT INTO Expense (projectid, bankAccountId, name, amount, date, paymentType) VALUES (2, 2, 'Meubles', 1809.95, '2023-06-27', 'CREDIT');");

        db.execSQL("INSERT INTO Agreement (projectId, subject, content) VALUES (1, 'Matériaux', 'Les planchers doivent être construits en diamant')");
        db.execSQL("INSERT INTO Agreement (projectId, subject, content) VALUES (2, 'Matériaux', 'Les planchers doivent être construits en or')");
        db.execSQL("INSERT INTO Agreement (projectId, subject, content) VALUES (1, 'Plomberie', 'La plomberie doit être effectuée par Mario')");
        db.execSQL("INSERT INTO Agreement (projectId, subject, content) VALUES (2, 'Plomberie', 'La plomberie doit être effectuée par Luigi')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
