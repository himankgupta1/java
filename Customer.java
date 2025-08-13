public class Customer {
    private int customerId;
    private String name;
    private String mailId;
    private String contact;
    private String accountType;

    public Customer(int customerId, String name, String mailId, String contact, String accountType) {
        this.customerId = customerId;
        this.name = name;
        this.mailId = mailId;
        this.contact = contact;
        this.accountType = accountType;
    }

    // Getters
    public int getCustomerId() { return customerId; }
    public String getName() { return name; }
    public String getMailId() { return mailId; }
    public String getContact() { return contact; }
    public String getAccountType() { return accountType; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setMailId(String mailId) { this.mailId = mailId; }
    public void setContact(String contact) { this.contact = contact; }
    public void setAccountType(String accountType) { this.accountType = accountType; }

    @Override
    public String toString() {
        return "Customer Id = " + customerId +
                ", Name = " + name +
                ", Email = " + mailId +
                ", Contact = " + contact +
                ", Account Type = " + accountType;
    }
}
