package dev.paintilya.android_projects_manager.FEL;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import dev.paintilya.android_projects_manager.BLL.Model.Expense;
import dev.paintilya.android_projects_manager.DAL.ExpenseSQLiteDAO;
import dev.paintilya.android_projects_manager.DAL.IExpenseDAO;
import dev.paintilya.android_projects_manager.R;

public class AddExpenseActivity extends AppCompatActivity {

    EditText name_txt, amount_txt;
    IExpenseDAO dao;

    Bundle extra;
    int projectId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        // init
        this.name_txt = findViewById(R.id.add_expense_name_txt);
        this.amount_txt = findViewById(R.id.add_expense_amount_txt);

        this.dao = new ExpenseSQLiteDAO(this);

        this.extra = getIntent().getExtras();
        this.projectId = this.extra.getInt("projectId");
    }

    public void onAddBtnClick(View view) {
        Expense newExpense = new Expense(0, this.projectId, this.name_txt.getText().toString(), Double.parseDouble(this.amount_txt.getText().toString()));
        this.dao.addExpense(newExpense);
    }
}