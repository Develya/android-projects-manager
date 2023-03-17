package dev.paintilya.android_projects_manager.Control;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.paintilya.android_projects_manager.BLL.Model.Expense;
import dev.paintilya.android_projects_manager.DAL.IProjectDAO;
import dev.paintilya.android_projects_manager.DAL.ProjectSQLiteDAO;
import dev.paintilya.android_projects_manager.R;

public class TransactionsAdapter extends RecyclerView.Adapter<TransactionsViewHolder> {
    List<Expense> transactions;
    IProjectDAO projectDAO;

    public TransactionsAdapter(List<Expense> transactions, Context context) {
        this.transactions = transactions;
        this.projectDAO = new ProjectSQLiteDAO(context);
    }

    @NonNull
    @Override
    public TransactionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_transaction, parent, false);
        return new TransactionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionsViewHolder holder, int position) {
        holder.getName().setText(this.transactions.get(position).getName());
        holder.getProjectName().setText(this.projectDAO.getProjectById(this.transactions.get(position).getProjectId()).getName());
        Log.d("TESTING_TRANSACTIONS", holder.getProjectName().getText().toString());
        holder.getType().setText(this.transactions.get(position).getPaymentType());
        holder.getDate().setText(this.transactions.get(position).getDate());
        holder.getAmount().setText("-"+this.transactions.get(position).getAmount()+"$");
    }

    @Override
    public int getItemCount() {
        return this.transactions.size();
    }

    public List<Expense> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Expense> transactions) {
        this.transactions = transactions;
    }
}