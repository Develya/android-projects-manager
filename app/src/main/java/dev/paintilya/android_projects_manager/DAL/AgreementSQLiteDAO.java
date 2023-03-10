package dev.paintilya.android_projects_manager.DAL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import dev.paintilya.android_projects_manager.DL.SQLiteHelper;
import dev.paintilya.android_projects_manager.Model.Agreement;
import dev.paintilya.android_projects_manager.Model.PaymentMethod;

public class AgreementSQLiteDAO implements IAgreementDAO{

    SQLiteHelper helper;

    public AgreementSQLiteDAO(Context context) {
        this.helper = new SQLiteHelper(context);
    }

    @Override
    public int addAgreementByProjectId(int projectId, Agreement newAgreement) {
        SQLiteDatabase db = this.helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", newAgreement.getId());
        values.put("projectId", newAgreement.getProjectId());
        values.put("content", newAgreement.getContent());
        values.put("subject", newAgreement.getSubject());
        db.insert("Agreement", "id, projectId, content, subject", values);
        return 0; // Success
    }

    @Override
    public List<Agreement> getAllAgreementsByProjectId(int ProjectId) {
        SQLiteDatabase db = this.helper.getReadableDatabase();
        String request = "SELECT * FROM Agreement WHERE projectId == ProjectId";
        Cursor cursor = db.rawQuery(request, null);
        if (cursor != null) {
            cursor.moveToFirst();
            List<Agreement> agreements = new ArrayList<>();
            while (!cursor.isAfterLast()) {
                Agreement agreement = new Agreement();
                agreement.setId(cursor.getInt(0));
                agreement.setProjectId(cursor.getInt(1));
                agreement.setContent(cursor.getString(2));
                agreement.setSubject(cursor.getString(3));
                agreements.add(agreement);
                cursor.moveToNext();
            }
            db.close();
            return agreements;
        }

        return null;
    }

    @Override
    public int updateAgreementById(int id, String newSubject, String newContent) {
        SQLiteDatabase db = this.helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        Agreement agreement = new Agreement();
        agreement.setSubject(newSubject);
        agreement.setContent(newContent);
        values.put("subject", agreement.getSubject());
        values.put("content", agreement.getContent());

        db.update("Agreement",  values, "id = ?", new String[]{ id+"" });
        return 0;
    }

    @Override
    public int deleteAgreementById(int id) {
        Agreement agreement = new Agreement();
        if(agreement.getId() != id) {
            SQLiteDatabase db = this.helper.getWritableDatabase();
            db.delete("Agreement", "id = ?", new String[]{id + ""});
        }
        return 0; //success
    }
}
