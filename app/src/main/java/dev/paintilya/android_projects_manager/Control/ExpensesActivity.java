
package dev.paintilya.android_projects_manager.Control;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import dev.paintilya.android_projects_manager.DAL.ExpenseSQLiteDAO;
import dev.paintilya.android_projects_manager.DAL.IExpenseDAO;
import dev.paintilya.android_projects_manager.R;

public class ExpensesActivity extends AppCompatActivity {

    private Bundle extra;
    private int projectId;
    private IExpenseDAO dao;
    private RecyclerView recyclerView;
    private ExpenseAdapter adapter;
    private Button add_expense_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses);

        this.extra = this.getIntent().getExtras();

        if (extra != null)
            this.projectId = extra.getInt("projectId");

        this.dao = new ExpenseSQLiteDAO(this);

        this.recyclerView = findViewById(R.id.activity_expenses_recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        this.adapter = new ExpenseAdapter(dao.getAllExpensesByProjectId(this.projectId), this);
        recyclerView.setAdapter(adapter);
    }

    public void addExpenseBtnClick(View view) {
        Intent intent = new Intent(this, AddExpenseActivity.class);
        intent.putExtra("projectId", this.projectId);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();

        this.adapter.setExpenses(this.dao.getAllExpensesByProjectId(this.projectId));
        this.adapter.notifyDataSetChanged();
    }
}