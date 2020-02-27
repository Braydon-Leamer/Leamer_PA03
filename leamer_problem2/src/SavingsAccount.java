import java.util.Scanner;

public class SavingsAccount {
	static double annualInterestRate;
	private double savingsBalance;

	
	public SavingsAccount(double Balance) {
		savingsBalance = Balance;
	}
	
	public static void modifyInterestRate(double Rate) {
		annualInterestRate = Rate / 100.00;
	}

	public double calculateMonthlyInterest() {
		return (annualInterestRate * savingsBalance) / 12;
	}
	
	public static double getannualInterestRate() {
		return annualInterestRate;
	}
	public double getsavingsBalance() {
		return savingsBalance;
	}
}
