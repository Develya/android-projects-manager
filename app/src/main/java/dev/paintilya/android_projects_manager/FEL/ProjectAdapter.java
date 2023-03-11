package dev.paintilya.android_projects_manager.FEL;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.paintilya.android_projects_manager.BLL.Model.Project;
import dev.paintilya.android_projects_manager.R;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectViewHolder> {

    List<Project> projects;

    public ProjectAdapter(List<Project> projects) {
        this.projects = projects;
    }

    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_project, parent, false);
        return new ProjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder holder, int position) {
        holder.getName().setText(this.projects.get(position).getName());

        holder.setId(this.projects.get(position).getId());
        holder.getExpenses().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.getContext(), ExpensesActivity.class);
                intent.putExtra("projectId", holder.getId());
                holder.getContext().startActivity(intent);
            }
        });

        holder.getAgreements().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.getContext(), AgreementsActivity.class);
                intent.putExtra("projectId", holder.getId());
                holder.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.projects.size();
    }
}
