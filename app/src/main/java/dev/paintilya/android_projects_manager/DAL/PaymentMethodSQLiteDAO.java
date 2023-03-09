package dev.paintilya.android_projects_manager.DAL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import dev.paintilya.android_projects_manager.DL.SQLiteHelper;
import dev.paintilya.android_projects_manager.Model.PaymentMethod;

public class PaymentMethodSQLiteDAO implements IPaymentMethodDAO{

    SQLiteHelper helper;

    public PaymentMethodSQLiteDAO(Context context) {
        this.helper = new SQLiteHelper(context);
    }

    @Override
    public int addPaymentMethodByExpenseId(int expenseId, PaymentMethod newPaymentMethod) {
        SQLiteDatabase db = this.helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("expenseId", newPaymentMethod.getExpenseId());
        values.put("bankAccountId", newPaymentMethod.getBankAccountId());
        values.put("type", newPaymentMethod.getType());
        values.put("transactionDate", newPaymentMethod.getTransactionDate());
        db.insert("PaymentMethod", "expenseId, bankAccountId, type, transactionDate", values);
        return 0; // Success
    }

    @Override
    public List<PaymentMethod> getAllBankCheckPaymentMethods() {
        SQLiteDatabase db = this.helper.getReadableDatabase();
        String request = "SELECT * FROM PaymentMethod";
        Cursor cursor = db.rawQuery(request, null);
        if (cursor != null) {
            cursor.moveToFirst();
            List<PaymentMethod> paymentMethods = new ArrayList<>();
            while (!cursor.isAfterLast()) {
                PaymentMethod paymentMethod = new PaymentMethod();
                paymentMethod.setId(cursor.getInt(0));
                paymentMethod.setExpenseId(cursor.getInt(1));
                paymentMethod.setBankAccountId(cursor.getInt(2));
                paymentMethod.setType(cursor.getString(3));
                paymentMethod.setTransactionDate(cursor.getString(4));
                paymentMethods.add(paymentMethod);
                cursor.moveToNext();
            }
            db.close();
            return paymentMethods;
        }

        return null;
    }
}
