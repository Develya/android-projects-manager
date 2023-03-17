package dev.paintilya.android_projects_manager.Control;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import dev.paintilya.android_projects_manager.DAL.IBankAccountDAO;
import dev.paintilya.android_projects_manager.R;

public class BankAccountViewHolder extends RecyclerView.ViewHolder {
    int id;
    private TextView name, balance;
    private Button transaction;
    private IBankAccountDAO dao;
    private Context context;

    public BankAccountViewHolder(@NonNull View itemView) {
        super(itemView);

        this.name = itemView.findViewById(R.id.item_bankAccount_tv_name);
        this.balance = itemView.findViewById(R.id.item_bankAccount_tv_balance);
        this.transaction = itemView.findViewById(R.id.item_bankAccount_btn_transactions);

        this.context = name.getContext();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TextView getName() {
        return name;
    }

    public void setName(TextView name) {
        this.name = name;
    }

    public TextView getBalance() {
        return balance;
    }

    public void setBalance(TextView balance) {
        this.balance = balance;
    }

    public IBankAccountDAO getDao() {
        return dao;
    }

    public void setDao(IBankAccountDAO dao) {
        this.dao = dao;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Button getTransaction() {
        return transaction;
    }

    public void setTransaction(Button transaction) {
        this.transaction = transaction;
    }
}
