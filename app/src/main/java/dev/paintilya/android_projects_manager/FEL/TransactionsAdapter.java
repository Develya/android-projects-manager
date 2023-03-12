package dev.paintilya.android_projects_manager.FEL;

import android.view.LayoutInflater;
import android.view.SurfaceControl;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.paintilya.android_projects_manager.BLL.Model.PaymentMethod;
import dev.paintilya.android_projects_manager.R;

public class TransactionsAdapter extends RecyclerView.Adapter<TransactionsViewHolder> {
    List<PaymentMethod> transactions;

    public TransactionsAdapter(List<PaymentMethod> transactions) {
        this.transactions = transactions;
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
        holder.getType().setText(this.transactions.get(position).getType());

        holder.getDate().setText(this.transactions.get(position).getTransactionDate());
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
