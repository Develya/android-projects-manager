package dev.paintilya.android_projects_manager.Control;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import dev.paintilya.android_projects_manager.R;

public class TransactionsViewHolder extends RecyclerView.ViewHolder {
    private TextView name, projectName, type, date, amount;
    public TransactionsViewHolder(@NonNull View itemView) {
        super(itemView);
        this.name = itemView.findViewById(R.id.item_transaction_tv_name);
        this.projectName = itemView.findViewById(R.id.item_transaction_tv_projectName);
        this.type = itemView.findViewById(R.id.item_transaction_tv_type);
        this.date = itemView.findViewById(R.id.item_transaction_tv_date);
        this.amount = itemView.findViewById(R.id.item_transaction_tv_amount);
    }

    public TextView getType() {
        return type;
    }

    public void setType(TextView type) {
        this.type = type;
    }

    public TextView getDate() {
        return date;
    }

    public void setDate(TextView date) {
        this.date = date;
    }

    public TextView getName() {
        return name;
    }

    public void setName(TextView name) {
        this.name = name;
    }

    public TextView getProjectName() {
        return projectName;
    }

    public void setProjectName(TextView projectName) {
        this.projectName = projectName;
    }

    public TextView getAmount() {
        return amount;
    }

    public void setAmount(TextView amount) {
        this.amount = amount;
    }
}
