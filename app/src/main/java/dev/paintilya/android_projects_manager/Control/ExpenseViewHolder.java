package dev.paintilya.android_projects_manager.Control;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import dev.paintilya.android_projects_manager.R;

public class ExpenseViewHolder extends RecyclerView.ViewHolder {

    private TextView name, amount, bankAccount;
    private int id;

    public ExpenseViewHolder(@NonNull View itemView) {
        super(itemView);
        this.name = itemView.findViewById(R.id.item_expense_tv_name);
        this.amount = itemView.findViewById(R.id.item_expense_tv_amount);
        this.bankAccount = itemView.findViewById(R.id.item_expense_tv_bankAccount);
    }

    public TextView getName() {
        return name;
    }

    public void setName(TextView name) {
        this.name = name;
    }

    public TextView getAmount() {
        return amount;
    }

    public void setAmount(TextView amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TextView getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(TextView bankAccount) {
        this.bankAccount = bankAccount;
    }
}
