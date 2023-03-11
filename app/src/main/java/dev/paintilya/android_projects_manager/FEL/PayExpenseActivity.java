package dev.paintilya.android_projects_manager.FEL;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.List;

import dev.paintilya.android_projects_manager.BLL.Model.BankAccount;
import dev.paintilya.android_projects_manager.BLL.Model.Expense;
import dev.paintilya.android_projects_manager.BLL.Model.PaymentMethod;
import dev.paintilya.android_projects_manager.DAL.BankAccountSQLiteDAO;
import dev.paintilya.android_projects_manager.DAL.IBankAccountDAO;
import dev.paintilya.android_projects_manager.DAL.IPaymentMethodDAO;
import dev.paintilya.android_projects_manager.DAL.PaymentMethodSQLiteDAO;
import dev.paintilya.android_projects_manager.R;

public class PayExpenseActivity extends AppCompatActivity {

    EditText bankAccountId_txt, type_txt, date_txt;
    Button pay_btn;

    Bundle extra;
    int expenseId;

    IPaymentMethodDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_expense);

        // init
        this.bankAccountId_txt = findViewById(R.id.pay_expense_bankAccountId_txt);
        this.type_txt = findViewById(R.id.pay_expense_type_txt);
        this.date_txt = findViewById(R.id.pay_expense_date_txt);
        this.pay_btn = findViewById(R.id.pay_Expense_pay_btn);

        this.extra = this.getIntent().getExtras();
        this.expenseId = this.extra.getInt("expenseId");

        this.dao = new PaymentMethodSQLiteDAO(this);
    }

    public void onPayBtnClick(View v) {
        PaymentMethod newTransaction = new PaymentMethod(
                0,
                this.expenseId,
                Integer.parseInt(this.bankAccountId_txt.getText().toString()),
                this.type_txt.getText().toString(),
                this.date_txt.getText().toString()
        );

        dao.addPaymentMethodByExpenseId(this.expenseId, new PaymentMethod());
        finish();
    }
}