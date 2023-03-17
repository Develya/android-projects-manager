package dev.paintilya.android_projects_manager.Control;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.paintilya.android_projects_manager.BLL.Model.Agreement;
import dev.paintilya.android_projects_manager.R;

public class AgreementAdapter extends RecyclerView.Adapter<AgreementViewHolder> {

    private List<Agreement> agreements;

    public AgreementAdapter(List<Agreement> agreements) {
        this.agreements = agreements;
    }

    @NonNull
    @Override
    public AgreementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_agreement, parent, false);
        return new AgreementViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AgreementViewHolder holder, int position) {
        holder.getSubject().setText(this.agreements.get(position).getSubject());
        holder.getContent().setText(this.agreements.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return this.agreements.size();
    }

    public List<Agreement> getAgreements() {
        return agreements;
    }

    public void setAgreements(List<Agreement> agreements) {
        this.agreements = agreements;
    }
}
