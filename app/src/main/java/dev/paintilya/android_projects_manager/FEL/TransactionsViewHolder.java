package dev.paintilya.android_projects_manager.FEL;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import dev.paintilya.android_projects_manager.R;

public class TransactionsViewHolder extends RecyclerView.ViewHolder {
    private TextView type, date;
    public TransactionsViewHolder(@NonNull View itemView) {
        super(itemView);
        this.type = itemView.findViewById(R.id.transaction_tv_type);
        this.date = itemView.findViewById(R.id.transaction_tv_date);
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
}
