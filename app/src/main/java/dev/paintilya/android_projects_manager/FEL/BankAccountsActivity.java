package dev.paintilya.android_projects_manager.FEL;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;

import dev.paintilya.android_projects_manager.DAL.IBankAccountDAO;
import dev.paintilya.android_projects_manager.R;

public class BankAccountsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BankAccountAdapter adapter;
    private IBankAccountDAO dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_accounts);

        this.recyclerView = findViewById(R.id.bankaccount_recycleview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        this.adapter = new BankAccountAdapter(dao.getAllAccounts());
        recyclerView.setAdapter(adapter);
    }
}