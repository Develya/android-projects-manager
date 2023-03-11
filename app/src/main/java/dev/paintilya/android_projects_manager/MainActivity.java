package dev.paintilya.android_projects_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import dev.paintilya.android_projects_manager.DAL.AgreementSQLiteDAO;
import dev.paintilya.android_projects_manager.DAL.BankAccountSQLiteDAO;
import dev.paintilya.android_projects_manager.DAL.IPaymentMethodDAO;
import dev.paintilya.android_projects_manager.DAL.PaymentMethodSQLiteDAO;
import dev.paintilya.android_projects_manager.Model.Agreement;
import dev.paintilya.android_projects_manager.Model.BankAccount;
import dev.paintilya.android_projects_manager.Model.PaymentMethod;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BankAccountSQLiteDAO dao = new BankAccountSQLiteDAO(this);
        this.deleteDatabase("projects.db");

        /*int result = dao.addPaymentMethodByExpenseId(1, new PaymentMethod(1, 1, 1, "check", "09-03-2023"));
        Log.d("IEATPASTA", "result: "+result);

        List<PaymentMethod> paymentMethods = dao.getAllBankCheckPaymentMethods();
        for (PaymentMethod paymentMethod : paymentMethods) {
            Log.d("IEATPIZZA", paymentMethod.toString());
        }*/

        /*int result = dao.addAgreementByProjectId(1, new Agreement(1,1,"heh", "heh"));
        Log.d("TBNK", "result:" + result);

        List<Agreement> agreements = dao.getAllAgreementsByProjectId(1);
        for(Agreement agreement : agreements){
            Log.d("Colisse", agreement.toString());
        }
        dao.updateAgreementById(1,"CHeh","Cheh");
        Log.d("update",dao.toString());

        int result2 = dao.deleteAgreementById(1);
        Log.d("delete", "result " + result2);*/

        List<BankAccount> bankAccounts = dao.getAllAccounts();
        for(BankAccount bankAccount : bankAccounts){
            Log.d("TESTING_GET", bankAccount.toString());
        }

        int result = dao.updateBankAccountBalanceById(1, 9999);
        Log.d("TESTING_UPDATE", "result " + result);

        bankAccounts = dao.getAllAccounts();
        for(BankAccount bankAccount : bankAccounts){
            Log.d("TESTING_UPDATE_GET", bankAccount.toString());
        }
    }
}