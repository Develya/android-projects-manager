package dev.paintilya.android_projects_manager.Control;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import dev.paintilya.android_projects_manager.DAL.ExpenseSQLiteDAO;
import dev.paintilya.android_projects_manager.DAL.IExpenseDAO;
import dev.paintilya.android_projects_manager.R;

public class TransactionsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TransactionsAdapter adapter;
    private IExpenseDAO dao;
    private Bundle extra;
    private int bankAccountId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);

        this.dao = new ExpenseSQLiteDAO(this);

        this.extra = this.getIntent().getExtras();

        if (extra != null)
            this.bankAccountId = extra.getInt("bankAccountId");

        this.recyclerView = findViewById(R.id.activity_transactions_recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        this.adapter = new TransactionsAdapter(dao.getAllExpensesByBankAccountId(this.bankAccountId), this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        this.adapter.setTransactions(this.dao.getAllExpensesByBankAccountId(this.bankAccountId));
        this.adapter.notifyDataSetChanged();
    }
}