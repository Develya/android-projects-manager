package dev.paintilya.android_projects_manager.FEL;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import dev.paintilya.android_projects_manager.R;

public class ExpenseViewHolder extends RecyclerView.ViewHolder {

    private TextView name, amount;
    private int id;
    private Button pay;

    public ExpenseViewHolder(@NonNull View itemView) {
        super(itemView);
        this.name = itemView.findViewById(R.id.expense_tv_name);
        this.amount = itemView.findViewById(R.id.expense_tv_amount);
        this.pay = itemView.findViewById(R.id.expense_btn_pay);
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

    public Button getPay() {
        return pay;
    }

    public void setPay(Button pay) {
        this.pay = pay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
