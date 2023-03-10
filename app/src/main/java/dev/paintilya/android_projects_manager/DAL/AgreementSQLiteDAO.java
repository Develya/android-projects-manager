package dev.paintilya.android_projects_manager.DAL;

import java.util.List;

import dev.paintilya.android_projects_manager.Model.Agreement;

public class AgreementSQLiteDAO implements IAgreementDAO{
    @Override
    public int addAgreementByProjectId(int projectId, Agreement newAgreement) {
        return 0;
    }

    @Override
    public List<Agreement> getAllAgreementsByProjectId(int projectId) {
        return null;
    }

    @Override
    public int updateAgreementById(int id, String newSubject, String newContent) {
        return 0;
    }

    @Override
    public int deleteAgreementById(int id) {
        return 0;
    }
}
