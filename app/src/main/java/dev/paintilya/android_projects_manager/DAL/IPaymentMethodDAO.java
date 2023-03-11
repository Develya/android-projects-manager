package dev.paintilya.android_projects_manager.DAL;


import java.util.List;

import dev.paintilya.android_projects_manager.Model.PaymentMethod;

public interface IPaymentMethodDAO {
    /*
        CRUD
    */

    // Create
    public int addPaymentMethodByExpenseId(int expenseId, PaymentMethod newPaymentMethod);

    // Read
    public List<PaymentMethod> getAllPaymentMethods();

    // Update
    // Not needed

    // Delete
    // Not needed
}
