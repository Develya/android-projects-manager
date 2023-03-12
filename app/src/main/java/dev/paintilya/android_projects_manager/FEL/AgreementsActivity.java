package dev.paintilya.android_projects_manager.FEL;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import dev.paintilya.android_projects_manager.DAL.AgreementSQLiteDAO;
import dev.paintilya.android_projects_manager.DAL.IAgreementDAO;
import dev.paintilya.android_projects_manager.DAL.IExpenseDAO;
import dev.paintilya.android_projects_manager.R;

public class AgreementsActivity extends AppCompatActivity {
    private Bundle extra;
    private int projectId;
    private IAgreementDAO dao;
    private RecyclerView recyclerView;
    private AgreementAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agreements);

        this.extra = this.getIntent().getExtras();

        if(extra != null)
            projectId = extra.getInt("projectId");
        this.dao = new AgreementSQLiteDAO(this);

        this.recyclerView = findViewById(R.id.agreement_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        this.adapter = new AgreementAdapter(dao.getAllAgreementsByProjectId(this.projectId));
        recyclerView.setAdapter(adapter);
    }

    public void addAgreementBtnClick(View view){
        Intent intent = new Intent(this, AddAgreementActivity.class);
        intent.putExtra("projectId", this.projectId);
        startActivity(intent);
    }
}