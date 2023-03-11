package dev.paintilya.android_projects_manager.FEL;

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
        View view = inflater.inflate(R.layout.projectsfichier, parent, false);
        return new ProjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder holder, int position) {
        holder.getName().setText(this.projects.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return this.projects.size();
    }
}
