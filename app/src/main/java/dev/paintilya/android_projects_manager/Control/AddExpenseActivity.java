package dev.paintilya.android_projects_manager.Control;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import dev.paintilya.android_projects_manager.BLL.Model.BankAccount;
import dev.paintilya.android_projects_manager.BLL.Model.Expense;
import dev.paintilya.android_projects_manager.DAL.BankAccountSQLiteDAO;
import dev.paintilya.android_projects_manager.DAL.ExpenseSQLiteDAO;
import dev.paintilya.android_projects_manager.DAL.IBankAccountDAO;
import dev.paintilya.android_projects_manager.DAL.IExpenseDAO;
import dev.paintilya.android_projects_manager.R;

public class AddExpenseActivity extends AppCompatActivity {

    EditText name_txt, amount_txt, bankAccountId_txt, paymentType_txt, date_txt;
    IExpenseDAO expenseDAO;
    IBankAccountDAO bankAccountDAO;
    Bundle extra;
    int projectId;

    DecimalFormat moneyFormat = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        // init

        moneyFormat.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.ENGLISH));

        this.name_txt = findViewById(R.id.activity_add_expense_txt_name);
        this.amount_txt = findViewById(R.id.activity_add_expense_txt_amount);
        this.bankAccountId_txt = findViewById(R.id.activity_add_expense_txt_bankAccountId);
        this.paymentType_txt = findViewById(R.id.activity_add_expense_txt_paymentType);
        this.date_txt = findViewById(R.id.activity_add_expense_txt_date);

        this.expenseDAO = new ExpenseSQLiteDAO(this);
        this.bankAccountDAO = new BankAccountSQLiteDAO(this);

        this.extra = getIntent().getExtras();
        this.projectId = this.extra.getInt("projectId");
    }

    public void onAddBtnClick(View view) {
        Expense newExpense = new Expense(0, this.projectId, Integer.parseInt(this.bankAccountId_txt.getText().toString()), this.name_txt.getText().toString(), this.date_txt.getText().toString(), this.paymentType_txt.getText().toString(), Double.parseDouble(this.amount_txt.getText().toString()));
        this.expenseDAO.addExpense(newExpense);

        double currentBalance = this.bankAccountDAO.getBankAccountBalanceById(Integer.parseInt(this.bankAccountId_txt.getText().toString()));

        this.bankAccountDAO.updateBankAccountBalanceById(Integer.parseInt(this.bankAccountId_txt.getText().toString()), Double.parseDouble(moneyFormat.format(currentBalance - Double.parseDouble(this.amount_txt.getText().toString()))));

        finish();
    }

}