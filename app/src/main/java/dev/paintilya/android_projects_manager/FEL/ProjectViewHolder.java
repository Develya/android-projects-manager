package dev.paintilya.android_projects_manager.FEL;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import dev.paintilya.android_projects_manager.R;

public class ProjectViewHolder extends RecyclerView.ViewHolder {

    private int id;
    private TextView name;
    private Button expenses;
    private Button agreements;

    private Context context;

    public ProjectViewHolder(@NonNull View itemView) {
        super(itemView);
        this.name = itemView.findViewById(R.id.project_name);
        this.expenses = itemView.findViewById(R.id.project_expenses);
        this.agreements = itemView.findViewById(R.id.project_agreements);

        this.context = name.getContext();
    }

    public TextView getName() {
        return name;
    }

    public void setName(TextView name) {
        this.name = name;
    }

    public Button getExpenses() {
        return expenses;
    }

    public void setExpenses(Button expenses) {
        this.expenses = expenses;
    }

    public Button getAgreements() {
        return agreements;
    }

    public void setAgreements(Button agreements) {
        this.agreements = agreements;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
