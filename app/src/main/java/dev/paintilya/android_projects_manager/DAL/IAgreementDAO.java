package dev.paintilya.android_projects_manager.DAL;

import java.util.List;

import dev.paintilya.android_projects_manager.BLL.Model.Agreement;

public interface IAgreementDAO {
    /*
        CRUD
    */

    // Create
    public int addAgreementByProjectId(int projectId, Agreement newAgreement);

    // Read
    public List<Agreement> getAllAgreementsByProjectId(int projectId);

    // Update
    public int updateAgreementById(int id, String newSubject, String newContent);

    // Delete
    public int deleteAgreementById(int id);
}
