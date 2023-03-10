package dev.paintilya.android_projects_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import dev.paintilya.android_projects_manager.DAL.AgreementSQLiteDAO;
import dev.paintilya.android_projects_manager.DAL.IPaymentMethodDAO;
import dev.paintilya.android_projects_manager.DAL.PaymentMethodSQLiteDAO;
import dev.paintilya.android_projects_manager.Model.Agreement;
import dev.paintilya.android_projects_manager.Model.PaymentMethod;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AgreementSQLiteDAO dao = new AgreementSQLiteDAO(this);

        /*int result = dao.addPaymentMethodByExpenseId(1, new PaymentMethod(1, 1, 1, "check", "09-03-2023"));
        Log.d("IEATPASTA", "result: "+result);

        List<PaymentMethod> paymentMethods = dao.getAllBankCheckPaymentMethods();
        for (PaymentMethod paymentMethod : paymentMethods) {
            Log.d("IEATPIZZA", paymentMethod.toString());
        }*/

        int result = dao.addAgreementByProjectId(1,new Agreement(1,1,"heh","heheh"));
        List<Agreement> agreements = dao.getAllAgreementsByProjectId(1);
        for( Agreement agreement : agreements){
            Log.d("IEATSOMETHING", "result" + result);
        }
    }
}