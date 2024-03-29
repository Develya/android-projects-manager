package dev.paintilya.android_projects_manager.DAL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import dev.paintilya.android_projects_manager.DL.SQLiteHelper;
import dev.paintilya.android_projects_manager.BLL.Model.Project;

public class ProjectSQLiteDAO implements IProjectDAO {

    private SQLiteHelper helper;

    public ProjectSQLiteDAO(Context context) { this.helper = new SQLiteHelper(context); }

    @Override
    public List<Project> getAllProjects() {
        SQLiteDatabase db = this.helper.getReadableDatabase();
        String request = "SELECT * FROM Project";
        Cursor cursor = db.rawQuery(request, null);
        if (cursor != null) {
            cursor.moveToFirst();
            List<Project> projects = new ArrayList<>();
            while (!cursor.isAfterLast()) {
                Project project = new Project();
                project.setId(cursor.getInt(0));
                project.setName(cursor.getString(1));
                project.setStartDate(cursor.getString(2));
                project.setEndDate(cursor.getString(3));
                projects.add(project);
                cursor.moveToNext();
            }
            cursor.close();
            db.close();
            return projects;
        }
        return null;
    }

    @Override
    public Project getProjectById(int id) {
        SQLiteDatabase db = this.helper.getReadableDatabase();
        String request = "SELECT * FROM Project WHERE id = ?";
        Cursor cursor = db.rawQuery(request, new String[]{""+id});
        if (cursor != null) {
            cursor.moveToFirst();
            Project project = new Project();
            while (!cursor.isAfterLast()) {
                project.setId(cursor.getInt(0));
                project.setName(cursor.getString(1));
                project.setStartDate(cursor.getString(2));
                project.setEndDate(cursor.getString(3));
                cursor.moveToNext();
            }
            cursor.close();
            db.close();
            return project;
        }
        return null;
    }

    @Override
    public int updateProjectEndDateById(int id, String endDate) {
        SQLiteDatabase db = this.helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("endDate", endDate);
        db.update("Project", values, "id = ?", new String[] { ""+id });
        db.close();
        return 0; // success
    }
}
