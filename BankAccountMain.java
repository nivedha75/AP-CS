import java.util.Scanner;



class BankAccount {
	private double balance;
	private String name;
	private int accountNumber;// each person creates a bank account and this is their number
	private static int accountCreated = 10000000;// for all bank accounts in the bank

	public double getBalance() {
		return balance;
	}
	public void BankAccount() {
		System.out.println("hello");
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BankAccount(String n) {
		name = n;
		balance = 0;
		accountCreated++;
		accountNumber = accountCreated;
		if (accountCreated % 100 == 0)
			balance += 100;
	}

	public BankAccount(String n, double b) {
		balance = b;
		name = n;
		accountCreated++;
		accountNumber = accountCreated;
		if (accountCreated % 100 == 0)
			balance += 100;
	}

	public String toString() {
		double balanceString = (int) (balance * 100) / 100.0;
		if ((int) (balanceString * 100) % 10 == 0)
			return name + "'s account " + accountNumber + " has a balance of $" + balanceString + "0 dollars.";
		else
			return name + "'s account " + accountNumber + " has a balance of $" + balanceString + " dollars.";

	}

	public void deposit(double money) {
		if (money > 0) {
			balance += money;
			double depositString = (int) (money * 100) / 100.0;
			if ((int) (depositString * 100) % 10 == 0)
				System.out.println(name + "'s account " + accountNumber + " got a deposit of $"
						+ depositString + "0 dollars.");
			else
				System.out.println(name + "'s account " + accountNumber + " got a depsosit of $"
						+ depositString + " dollars.");
			System.out.println(this.toString() + "\n");
		} else {
			System.out.println("Invalid deposit amount.");
		}
	}

	public double withdraw(double money) {
		if (money > balance) {
			balance -= 10;
			System.out.println("You cannot withdraw that amount. You have a banking fee now.");
			return 0;
		} else {
			balance -= money;
			double withdrawString = (int) (money * 100) / 100.0;
			if ((int) (withdrawString * 100) % 10 == 0)
				System.out.println(name + "'s account " + accountNumber + " got a withdrawal of $"
						+ withdrawString + "0 dollars.");
			else
				System.out.println(name + "'s account " + accountNumber + " got a withdrawal of $"
						+ withdrawString + " dollars.");
			return money;
		}
	}

}

public class BankAccountMain {
	public static void main(String[] args) {
		BankAccount accAl = new BankAccount("Al", 50);
		accAl.BankAccount();
		BankAccount accBob = new BankAccount("Bob", 25);
		BankAccount accCarl = new BankAccount("Carl", 44);
		for (int i = 0; i < 500; i++) {
			BankAccount account = new BankAccount("Acct" + (i + 1), (i + 1));
			// if(i == 499) {
			// account.setBalance(37.5);
			// }
			System.out.println(account.toString());
		}
		System.out.println();
		BankAccount[] accts = new BankAccount[100];
		int acctIndex = -1;
		boolean continueToRun = true;
		System.out.println("Welcome to Banking Central!\n");
		while (continueToRun) {
			Scanner s = new Scanner(System.in);
			System.out.println("1. Create new account");
			System.out.println("2. View all accounts");
			System.out.println("3. Quit");
			System.out.println("4. Deposit or Withdraw");
			System.out.println("Enter your selection: ");
			int choice = s.nextInt();
			if (choice == 1) {
				System.out.println();
				Scanner n = new Scanner(System.in);
				System.out.println("What is your name?");
				String name = n.nextLine();
				Scanner b = new Scanner(System.in);
				System.out.println("Your starting balance: ");
				double balance = b.nextDouble();
				if (acctIndex < 99) {
					BankAccount acc = new BankAccount(name, balance);
					acctIndex++;
					accts[acctIndex] = acc;
					System.out.println("You made a banking account!");
				} else {
					System.out.println("You cannot make more than 100 accounts.");
				}
				System.out.println();
			} else if (choice == 2) {
				System.out.println();
				for (int i = 0; i <= acctIndex; i++) {
					System.out.println(accts[i].toString());
				}
				System.out.println();
			} else if (choice == 3) {
				System.out.println();
				continueToRun = false;
				System.out.println("Thank you for banking!");
				System.out.println();
			} else if (choice == 4) {
				Scanner n = new Scanner(System.in);
				System.out.println("What is your name?");
				String name = n.nextLine();
				Scanner acct = new Scanner(System.in);
				System.out.println("What is your account number?");
				int acctNum = acct.nextInt();
				int count = 0;
				for (int i = 0; i <= acctIndex; i++) {
					if (accts[acctIndex].getAccountNumber() == acctNum
							&& accts[acctIndex].getName().equalsIgnoreCase(name)) {
						count++;
						Scanner s2 = new Scanner(System.in);
						System.out.println("1. Deposit");
						System.out.println("2. Withdraw");
						System.out.println("Enter your selection: ");
						int choice2 = s2.nextInt();
						if (choice2 == 1) {
							Scanner d = new Scanner(System.in);
							System.out.println("How much do you want to deposit in the account?");
							double deposit = d.nextDouble();
							accts[acctIndex].deposit(deposit);
						} else if (choice2 == 2) {
							Scanner w = new Scanner(System.in);
							System.out.println("How much do you want to withdraw from the account?");
							double withdraw = w.nextDouble();
							double withdrawAmount = accts[acctIndex].withdraw(withdraw);
							if(withdrawAmount != 0) 
								System.out.println(accts[acctIndex].toString() + "\n");
						} else {
							System.out.println("You entered an invalid number.");
						}

					}
				}
				if(count == 0) {
					System.out.println("There is no account number with that name. Check to see if you entered the right information.");
				}
			} else {
				System.out.println("You entered an invalid number.");
			}
		}
		

	}
}
