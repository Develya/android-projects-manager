package dev.paintilya.android_projects_manager.DAL;

import java.util.List;

import dev.paintilya.android_projects_manager.BLL.Model.Project;

public interface IProjectDAO {
    /*
        CRUD
    */

    // Create
    // Not needed

    // Read
    public List<Project> getAllProjects();
    public Project getProjectById(int id);

    // Update
    public int updateProjectEndDateById(int id, String endDate);

    // Delete
    // Not needed
}
