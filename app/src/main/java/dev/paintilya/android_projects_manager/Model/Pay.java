package dev.paintilya.android_projects_manager.Model;

public class Pay {
    private int id, expenseId, bankAccountId;
    private String type, transactionDate;

    public Pay() {}

    public Pay(int id, int expenseId, int bankAccountId, String type, String transactionDate) {
        this.id = id;
        this.expenseId = expenseId;
        this.bankAccountId = bankAccountId;
        this.type = type;
        this.transactionDate = transactionDate;
    }

    @Override
    public String toString() {
        return "Pay{" +
                "id=" + id +
                ", expenseId=" + expenseId +
                ", bankAccountId=" + bankAccountId +
                ", type='" + type + '\'' +
                ", transactionDate='" + transactionDate + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public int getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(int bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }
}
