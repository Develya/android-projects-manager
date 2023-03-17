package dev.paintilya.android_projects_manager.Control;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import dev.paintilya.android_projects_manager.BLL.Model.BankAccount;
import dev.paintilya.android_projects_manager.DAL.BankAccountSQLiteDAO;
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

        this.dao = new BankAccountSQLiteDAO(this);

        this.recyclerView = findViewById(R.id.bankaccount_recycleview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        this.recyclerView.setLayoutManager(layoutManager);
        this.adapter = new BankAccountAdapter(this.dao.getAllBankAccounts());
        this.recyclerView.setAdapter(this.adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        this.adapter.setBankAccounts(this.dao.getAllBankAccounts());
        this.adapter.notifyDataSetChanged();

        for (BankAccount bankAccount : this.dao.getAllBankAccounts()) {
            Log.d("TESTING_RV_REFRESH", bankAccount.toString());
        }
    }
}