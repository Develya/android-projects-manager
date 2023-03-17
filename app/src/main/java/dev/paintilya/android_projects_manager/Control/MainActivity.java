package dev.paintilya.android_projects_manager.Control;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import dev.paintilya.android_projects_manager.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBankAccountsBtnClick(View view) {
        Intent intent = new Intent(this, BankAccountsActivity.class);
        startActivity(intent);
    }

    public void onProjectsBtnClick(View view) {
        Intent intent = new Intent(this, ProjectsActivity.class);
        startActivity(intent);
    }

    public void onResetBtnClick(View view) {
        this.deleteDatabase("projects.db");
    }
}