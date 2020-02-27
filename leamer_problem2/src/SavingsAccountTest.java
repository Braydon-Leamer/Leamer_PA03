
public class SavingsAccountTest {
	public static void main(String args[]) {
		double Balance1;
		double Balance2;
		
		SavingsAccount saver1 = new SavingsAccount(2000.0);
		SavingsAccount saver2 = new SavingsAccount(3000.0);
		
		SavingsAccount.modifyInterestRate(4);
		System.out.println("\t\tBalances utilizing a 4% interest");
		for(int i = 1; i < 13; i++) {
			Balance1 = saver1.getsavingsBalance() + saver1.calculateMonthlyInterest() * i;
			Balance2 = saver2.getsavingsBalance() + saver2.calculateMonthlyInterest() * i;
		
			System.out.printf("Balance for saver1 = %.2f [month %d]\t", Balance1, i);
			System.out.printf("Balance for saver2 = %.2f [month %d]\n", Balance2, i);
			
			if(i == 12) {
				System.out.println();
				SavingsAccount.modifyInterestRate(5);
				System.out.println("\t\tBalance after utilizing a 5% interest");
				
				Balance1 += saver1.calculateMonthlyInterest();
				Balance2 += saver2.calculateMonthlyInterest();
			
				System.out.printf("Balance for saver1 = %.2f [month 13]\t", Balance1);
				System.out.printf("Balance for saver2 = %.2f [month 13]\n", Balance2);
			}
		}
	} 
}
