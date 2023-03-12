package dev.paintilya.android_projects_manager.FEL;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import dev.paintilya.android_projects_manager.DAL.IPaymentMethodDAO;
import dev.paintilya.android_projects_manager.R;

public class TransactionsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TransactionsAdapter adapter;
    private IPaymentMethodDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);

        this.recyclerView = findViewById(R.id.transaction_recycleview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        this.adapter = new TransactionsAdapter(dao.getAllPaymentMethods());
        recyclerView.setAdapter(adapter);
    }
}