package dev.paintilya.android_projects_manager.FEL;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.paintilya.android_projects_manager.BLL.Model.BankAccount;
import dev.paintilya.android_projects_manager.R;

public class BankAccountAdapter extends RecyclerView.Adapter<BankAccountViewHolder> {
    List<BankAccount> bankAccounts;

    public BankAccountAdapter(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    @NonNull
    @Override
    public BankAccountViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_bank_account, parent, false);
        return new BankAccountViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BankAccountViewHolder holder, int position) {
        holder.getName().setText(this.bankAccounts.get(position).getName());

        holder.setId(this.bankAccounts.get(position).getId());

        holder.getTransaction().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.getContext(), TransactionsActivity.class);
                intent.putExtra("projectId", holder.getId());
                holder.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
