package dev.paintilya.android_projects_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import dev.paintilya.android_projects_manager.DAL.BankAccountSQLiteDAO;
import dev.paintilya.android_projects_manager.DAL.ExpenseSQLiteDAO;
import dev.paintilya.android_projects_manager.DAL.IBankAccountDAO;
import dev.paintilya.android_projects_manager.DAL.IPaymentMethodDAO;
import dev.paintilya.android_projects_manager.DAL.IProjectDAO;
import dev.paintilya.android_projects_manager.DAL.PaymentMethodSQLiteDAO;
import dev.paintilya.android_projects_manager.DAL.ProjectSQLiteDAO;
import dev.paintilya.android_projects_manager.DL.SQLiteHelper;
import dev.paintilya.android_projects_manager.Model.BankAccount;
import dev.paintilya.android_projects_manager.Model.Expense;
import dev.paintilya.android_projects_manager.Model.PaymentMethod;
import dev.paintilya.android_projects_manager.Model.Project;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.deleteDatabase("projects.db");

        IProjectDAO dao = new ProjectSQLiteDAO(this);

        List<Project> projects = dao.getAllProjects();
        Log.d("TESTING_GET", "heh");
        for (Project project : projects) {
            Log.d("TESTING_GET", project.toString());
        }

        int result = dao.updateProjectEndDateById(1, "2025-09-09");
        projects = dao.getAllProjects();
        for (Project project : projects) {
            Log.d("TESTING_UPDATE", project.toString());
        }
    }
}