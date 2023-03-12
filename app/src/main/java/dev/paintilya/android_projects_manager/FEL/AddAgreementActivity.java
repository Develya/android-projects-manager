package dev.paintilya.android_projects_manager.FEL;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import dev.paintilya.android_projects_manager.BLL.Model.Agreement;
import dev.paintilya.android_projects_manager.BLL.Model.Expense;
import dev.paintilya.android_projects_manager.DAL.AgreementSQLiteDAO;
import dev.paintilya.android_projects_manager.DAL.ExpenseSQLiteDAO;
import dev.paintilya.android_projects_manager.DAL.IAgreementDAO;
import dev.paintilya.android_projects_manager.R;

public class AddAgreementActivity extends AppCompatActivity {
    EditText subject_txt, content_txt;
    IAgreementDAO dao;
    Bundle extra;
    int projectId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_agreement);

        // init
        this.subject_txt = findViewById(R.id.addagreement_txt_subject);
        this.content_txt = findViewById(R.id.addagreement_txt_content);

        this.dao = new AgreementSQLiteDAO(this);

        this.extra = getIntent().getExtras();
        this.projectId = this.extra.getInt("projectId");
    }

    public void AddAgreementBtnClick(View view) {
        Agreement newAgreement = new Agreement(0, this.projectId, this.subject_txt.getText().toString(), this.content_txt.getText().toString());
        this.dao.addAgreementByProjectId(this.projectId, newAgreement);
    }
}