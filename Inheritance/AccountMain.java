package Inheritance;

import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Class;

//NOTE: pay function of CreditCardAccount should technically take from checking account
//(or savings account)

class Account {
	private String name;
	private static int accCreated = 0; // total bank accounts created
	private int accNum;// your account number
	private double balance;
	private String transactions[];

	public Account() {
		accNum = 1000000 + accCreated;
		accCreated++;
		transactions = null;
	}

	public Account(String name, double balance) {
		this.name = name;
		accNum = 1000000 + accCreated;
		accCreated++;
		transactions = null;
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static int getAccCreated() {
		return accCreated;
	}

	public static void setAccCreated(int accCreated) {
		Account.accCreated = accCreated;
	}

	public int getAccNum() {
		return accNum;
	}

	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}

	public String[] getTransactions() {
		return transactions;
	}

	public void setTransactions(String[] transactions) {
		this.transactions = transactions;
	}

	public double getBalance() {
		return balance;
	}

	public String toString() {
		return "Name: " + name + ", Acct: " + accNum + ", Balance: $" + balance;
	}

	public void deposit(double amt) {
		balance += amt;
		int index;
		if (transactions == null) {
			index = 0;
		} else {
			index = transactions.length;
		}
		String[] newT = new String[index+1];
		for (int i = 0; i < index; i++) {
			newT[i] = transactions[i];
		}
		newT[index] = "deposit " + amt;
		transactions = newT;
	}

	public double withdraw(double amt) {
		balance -= amt;
		int index;
		if (transactions == null) {
			index = 0;
		} else {
			index = transactions.length;
		}
		String[] newT = new String[index+1];
		for (int i = 0; i < index; i++) {
			newT[i] = transactions[i];
		}
		newT[index] = "withdraw " + amt;
		transactions = newT;
		return amt;
	}
}

class SavingsAccount extends Account {
	private double interestRate;

	public SavingsAccount() {
		super("No name", 0);
		interestRate = 0;
	}

	public SavingsAccount(String name, double balance, double interestRate) {
		super(name, balance);
		this.interestRate = interestRate;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public void applyInterest() {
		deposit(interestRate / 1200 * getBalance());
	}

	public String toString() {
		return super.toString() + ", Interest: " + interestRate + "%";
	}
}

class CreditCardAccount extends Account {
	private double interestRate;
	private String type;

	public CreditCardAccount() {
		super();
		interestRate = 0;
		type = "";
	}

	public CreditCardAccount(String name, double balance, double i, String type) {
		super(name, balance);
		interestRate = i;
		this.type = type;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void charge(double amt) {
		withdraw(amt);
	}

	public void pay(double amt) {
		deposit(amt);
	}

	public String toString() {
		return "Name: " + getName() + ", " + getType() + " Acct: " + getAccNum() + ", Balance: " + getBalance()
				+ ", Interest: " + getInterestRate() + "%";
	}
}

class CheckingAccount extends Account {
	public CheckingAccount() {
		super();
	}

	public CheckingAccount(String name, double balance) {
		super(name, balance);
	}

	public String toString() {
		return "Name: " + getName() + ", Checking Acct: " + getAccNum() + ", Balance: " + getBalance();
	}

}

class AccountMain {
	public static void main(String[] args) {
		boolean loopback = true;
		ArrayList<Account> accList = new ArrayList<Account>();
		while (loopback) {
			System.out.println();
			Account temp = null;
			Scanner option = new Scanner(System.in);
			System.out.println("1. Create new account");
			System.out.println("2. Deposit/Pay");
			System.out.println("3. Withdraw/Charge");
			System.out.println("4. Print report of all accounts");
			System.out.println("5. Print all transactions");
			System.out.println("6. Apply interest for # months into the future");
			System.out.println("7. Put 20 deposits from $1-$20 into each account");
			System.out.println("9. Exit");
			int choice = option.nextInt();
			if (choice == 1) {
				Scanner accountType = new Scanner(System.in);
				System.out.println("Do you want to create a 1) Savings account 2) Credit Card account, or "
						+ "3) Checking account?");
				int accType = accountType.nextInt();
				Scanner n = new Scanner(System.in);
				System.out.println("What is your name?");
				String name = n.nextLine();
				Scanner b = new Scanner(System.in);
				System.out.println("What is your starting balance?");
				double balance = b.nextDouble();
				if (accType == 1) {
					Scanner interestRate = new Scanner(System.in); //
					System.out.println("What is the interest rate that your bank provides?");
					double iR = interestRate.nextDouble();
					SavingsAccount s = new SavingsAccount(name, balance, iR);
					accList.add(s);
					System.out.println("You have created an account!");
					System.out.println(s.toString());
				} else if (accType == 2) {
					Scanner interestRate = new Scanner(System.in); //
					System.out.println("What is the interest rate that your bank provides?");
					double iR = interestRate.nextDouble();
					Scanner creditCardType = new Scanner(System.in);
					System.out.println("What is the credit card type(Visa, Mastercard, Amex, etc)?");
					String creditType = creditCardType.nextLine();
					CreditCardAccount cc = new CreditCardAccount(name, balance, iR, creditType);
					accList.add(cc);
					System.out.println("You have created an account!");
					System.out.println(cc.toString());
				} else {
					CheckingAccount c = new CheckingAccount(name, balance);
					accList.add(c);
					System.out.println("You have created an account!");
					System.out.println(c.toString());
				}
			} else if (choice == 2) {
				Scanner account = new Scanner(System.in);
				System.out.println("What is the account#?");
				int acc = account.nextInt();
				for (int i = 0; i < accList.size(); i++) {
					if (accList.get(i).getAccNum() == acc) {
						temp = accList.get(i);
						System.out.println(temp.getClass());
						//CHANGE: Moved the following logic inside for loop 
						if (temp instanceof CheckingAccount) {
							CheckingAccount cATemp = (CheckingAccount) temp;
							Scanner d = new Scanner(System.in);
							System.out.println("How much do want to deposit?");
							double deposit = d.nextDouble();
							cATemp.deposit(deposit);
							System.out.println(cATemp.toString());
							//CHANGE: updating arraylist to reflect deposit
							//accList.set(i, cATemp);
						} else if (temp instanceof SavingsAccount) {
							SavingsAccount sTemp = (SavingsAccount) temp;
							Scanner d = new Scanner(System.in);
							System.out.println("How much do want to deposit?");
							double deposit = d.nextDouble();
							sTemp.deposit(deposit);

							System.out.println(sTemp.toString());
						} else {
							CreditCardAccount ccTemp = (CreditCardAccount) temp;
							Scanner p = new Scanner(System.in);
							System.out.println("How much do want to pay?");
							double pay = p.nextDouble();
							ccTemp.pay(pay);
							System.out.println(ccTemp.toString());
						}
					}//if
				}//for
			} else if (choice == 3) {
				Scanner account = new Scanner(System.in);
				System.out.println("What is the account#?");
				int acc = account.nextInt();
				for (int i = 0; i < accList.size(); i++) {
					if (accList.get(i).getAccNum() == acc) {
						temp = accList.get(i);
					}
				}
				if (temp instanceof CheckingAccount) {
					CheckingAccount cATemp = (CheckingAccount) temp;
					Scanner w = new Scanner(System.in);
					System.out.println("How much do you want to withdraw?");
					double withdraw = w.nextDouble();
					cATemp.withdraw(withdraw);
					System.out.println(cATemp.toString());
				} else if (temp instanceof SavingsAccount) {
					SavingsAccount sTemp = (SavingsAccount) temp;
					Scanner w = new Scanner(System.in);
					System.out.println("How much do you want to withdraw?");
					double withdraw = w.nextDouble();
					sTemp.withdraw(withdraw);
					System.out.println(sTemp.toString());
				} else {
					CreditCardAccount ccTemp = (CreditCardAccount) temp;
					Scanner chargeMoney = new Scanner(System.in);
					System.out.println("How much do you want to charge?");
					double charge = chargeMoney.nextDouble();
					ccTemp.charge(charge);
					System.out.println(ccTemp.toString());
				}
			} else if (choice == 4) {
				for (int i = 0; i < accList.size(); i++) {
					System.out.println(accList.get(i).toString());
				}
			} else if (choice == 5) {
				for (int i = 0; i < accList.size(); i++) {
					System.out.println(accList.get(i).getAccNum() + ":");
					if(accList.get(i).getTransactions() == null) {
						System.out.println("No transactions made yet.");
					}else {
						for (int j = 0; j < accList.get(i).getTransactions().length; j++) {
							System.out.println(accList.get(i).getTransactions()[j]);
						}
					}
				}
			} else if (choice == 6) {
				Scanner account = new Scanner(System.in);
				System.out.println("What is the account#?");
				int acc = account.nextInt();
				for (int i = 0; i < accList.size(); i++) {
					if (accList.get(i).getAccNum() == acc) {
						temp = accList.get(i);
					}
				}
				if (temp instanceof SavingsAccount) {
					SavingsAccount sTemp = (SavingsAccount) temp;
					Scanner iInput = new Scanner(System.in);
					System.out.println("What is the interest the bank is providing you?");
					sTemp.setInterestRate(iInput.nextDouble());
					Scanner numTimes = new Scanner(System.in);
					System.out.println("How many months do you want to apply interest for?");
					int numberOfTimes = numTimes.nextInt();
					for (int i = 0; i < numberOfTimes; i++) {
						sTemp.applyInterest();
					}
					System.out.println(sTemp.toString());
				} else {
					System.out.println("It is not a savings account.");
				}
			} else if (choice == 7) {
				for (int i = 0; i < accList.size(); i++) {
					temp = accList.get(i);
					if (temp instanceof CreditCardAccount) {
						CreditCardAccount ccTemp = (CreditCardAccount) temp;
						for (int j = 1; j <= 20; j++) {
							ccTemp.pay(j);
						}
						System.out.println(ccTemp.toString());
					} else {
						for (int j = 1; j <= 20; j++) {
							temp.deposit(j);
						}
						System.out.println(temp.toString());
					}
				}
			} else {
				System.out.println("Exited program.");
				loopback = false;
			}
		}
	}

}
