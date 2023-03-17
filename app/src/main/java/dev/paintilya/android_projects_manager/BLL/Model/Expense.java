package dev.paintilya.android_projects_manager.BLL.Model;

public class Expense {
    private int id, projectId, bankAccountId;
    private String name, date, paymentType;
    private double amount;

    public Expense() {}

    public Expense(int id, int projectId, int bankAccountId, String name, String date, String paymentType, double amount) {
        this.id = id;
        this.projectId = projectId;
        this.bankAccountId = bankAccountId;
        this.name = name;
        this.date = date;
        this.paymentType = paymentType;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", bankAccountId=" + bankAccountId +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", amount=" + amount +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(int bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}
