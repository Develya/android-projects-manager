package dev.paintilya.android_projects_manager.FEL;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.paintilya.android_projects_manager.BLL.Model.Expense;
import dev.paintilya.android_projects_manager.DAL.PaymentMethodSQLiteDAO;
import dev.paintilya.android_projects_manager.R;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseViewHolder> {

    private List<Expense> expenses;

    public ExpenseAdapter(List<Expense> expenses) {
        this.expenses = expenses;
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
        if (this.expenses.get(position).isPaid(new PaymentMethodSQLiteDAO(holder.getName().getContext()))) {
            ((ViewGroup) holder.getPay().getParent()).removeView(holder.getPay());
        } else {
            holder.getPay().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(holder.getName().getContext(), PayExpenseActivity.class);
                    intent.putExtra("expenseId", holder.getId());
                    holder.getName().getContext().startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return this.expenses.size();
    }
}
