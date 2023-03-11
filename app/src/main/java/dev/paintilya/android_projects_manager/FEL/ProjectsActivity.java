package dev.paintilya.android_projects_manager.FEL;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import dev.paintilya.android_projects_manager.DAL.IProjectDAO;
import dev.paintilya.android_projects_manager.DAL.ProjectSQLiteDAO;
import dev.paintilya.android_projects_manager.R;

public class ProjectsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProjectAdapter adapter;
    private IProjectDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);

        this.deleteDatabase("projects.db");

        this.dao = new ProjectSQLiteDAO(this);

        this.recyclerView = findViewById(R.id.projects_recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        this.adapter = new ProjectAdapter(dao.getAllProjects());
        recyclerView.setAdapter(adapter);
    }
}