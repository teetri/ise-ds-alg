public class Account {
    private String accountId;
    private String accountName;
    private TransactionManager transactionManager;
    private double balance;

    public Account(String accountId, String accountName) {
    	// Put your code here
    	
    	this.accountId = accountId;
    	this.accountName = accountName;
    	this.transactionManager = TransactionManager.getInstance();
    	this.balance = 0;
    	
    	
    }

    public void deposit(double amount) throws NegativeAmountException {
    	// Put your code here
    	
    	if(amount < 0) {
    		throw new NegativeAmountException("Deposit must not be negative");
    	}
    	
    	String msg = String.format("DEPOSIT - Amount: %f - Account ID: %s", amount, this.accountId);
    	this.transactionManager.logTransaction(msg);
    	
    	this.balance += amount;
    }

    public void withdraw(double amount) throws NegativeAmountException, InsufficientAmountException {
    	// Put your code here
    	
    	if(amount < 0) {
    		throw new NegativeAmountException("Withdrawal must not be negative");
    	}
    	if(amount > this.balance) {
    		throw new InsufficientAmountException("Insufficient funds");
    	}
    	
    	String msg = String.format("WITHDRAWAL - Amount: %f - Account ID: %s", amount, this.accountId);
    	this.transactionManager.logTransaction(msg);
    	
    	this.balance -= amount;
    }

    public void transfer(Account targetAccount, double amount) throws NegativeAmountException, InsufficientAmountException {
    	// Put your code here
    	
    	if(amount < 0) {
    		throw new NegativeAmountException("Withdrawal must not be negative");
    	}
    	if(amount > this.balance) {
    		throw new InsufficientAmountException("Insufficient funds");
    	}
    	
    	String msg = String.format("TRANSFER - Amount: %f - From Account ID: %s - To Account ID: %s", amount, this.accountId, targetAccount.accountId);
    	this.transactionManager.logTransaction(msg);
    	
    	this.balance -= amount;
    	targetAccount.balance += amount;
    
    }

    public double getBalance() {
        return balance;
    }
    
    public String getAccountId() {
    	return accountId;
    }

}