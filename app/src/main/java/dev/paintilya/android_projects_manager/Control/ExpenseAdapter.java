package dev.paintilya.android_projects_manager.Control;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.paintilya.android_projects_manager.BLL.Model.Expense;
import dev.paintilya.android_projects_manager.DAL.BankAccountSQLiteDAO;
import dev.paintilya.android_projects_manager.DAL.IBankAccountDAO;
import dev.paintilya.android_projects_manager.R;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseViewHolder> {

    private List<Expense> expenses;
    private IBankAccountDAO bankAccountDAO;

    public ExpenseAdapter(List<Expense> expenses, Context context) {
        this.expenses = expenses;
        this.bankAccountDAO = new BankAccountSQLiteDAO(context);
    }

    @NonNull
    @Override
    public ExpenseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_expense, parent, false);
        return new ExpenseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpenseViewHolder holder, int position) {
        holder.getName().setText(this.expenses.get(position).getName());
        holder.getAmount().setText(this.expenses.get(position).getAmount()+"$");
        holder.getBankAccount().setText("from "+this.bankAccountDAO.getBankAccountById(this.expenses.get(position).getBankAccountId()).getName());
    }

    @Override
    public int getItemCount() {
        return this.expenses.size();
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public IBankAccountDAO getBankAccountDAO() {
        return bankAccountDAO;
    }

    public void setBankAccountDAO(IBankAccountDAO bankAccountDAO) {
        this.bankAccountDAO = bankAccountDAO;
    }
}
