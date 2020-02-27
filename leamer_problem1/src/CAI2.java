import java.security.SecureRandom;
import java.util.Scanner;
public class CAI2 {
	private static Scanner input = new Scanner(System.in);
	private static int num1, num2;
	private static	SecureRandom random = new SecureRandom();
	public static void main(String[] args) {

		num1 = random.nextInt(10);
		num2 = random.nextInt(10);
		quiz();
	}
	
	public static void quiz() {
		askQuestion(num1, num2);
		int answer = readResponse();
		isAnswerCorrect(answer, num1, num2);
	}
	
	static int readResponse() {
		int response = input.nextInt();
		return response;
	}
	
	static void askQuestion(int num1, int num2) {
		System.out.printf("How much is %d times %d ?\n", num1, num2);
	}
	

	
	static void isAnswerCorrect(int answer, int num1, int num2) {
		if(answer == num1 * num2) {
			displayCorrectResponse();
		}
		else displayIncorrectResponse();
	}
	
	static void displayIncorrectResponse() {
		int randNum;
		randNum = random.nextInt();
		switch(randNum) {
			case 0 : System.out.println("No. Please try again.");
			break;
			case 1 : System.out.println("Wrong. Try once more.");
			break;
			case 2 : System.out.println("Don't give up!");
			break;
			case 3 : System.out.println("No. Keep trying.");
		}
		quiz();
	}
		
	static void displayCorrectResponse() {		
		int randNum;
		randNum = random.nextInt();
		switch(randNum) {
			case 0 : System.out.println("Very good!");
			break;
			case 1 : System.out.println("Excellent!");
			break;
			case 2 : System.out.println("Nice work!");
			break;
			case 3 : System.out.println("Keep up the good work!");
			break;
		}
		
	}
	
}
