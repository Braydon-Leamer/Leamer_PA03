import java.security.SecureRandom;
import java.util.Scanner;
public class CAI5 {
	private static Scanner input = new Scanner(System.in);
	private static int num1, num2, numCorrect = 0;
	private static	SecureRandom random = new SecureRandom();
	
	public static void main(String[] args) {
		quiz();
	}
	
	public static void quiz() {
		String yesNo;
		int difficulty = readDifficulty();
		int type = readProblemType();
		if(type == 5) type = random.nextInt(4);
		for(int i = 0; i < 10; i++) {
			generateQuestionArgument(difficulty);
			askQuestion(num1, num2, type);
			double answer = readResponse();
			isAnswerCorrect(answer, num1, num2, type);
		}
		displayCompletionMessage();
		System.out.println("Would you like to solve a new problem set? (yes or no)");
		yesNo = input.nextLine();
		yesNo = input.nextLine();
		if(yesNo.contentEquals("yes")) quiz();
	}
	
	static int readResponse() {
		int response = input.nextInt();
		return response;
	}
	
	static void askQuestion(int num1, int num2, int type) {
		switch(type) {
			case 1 : System.out.printf("How much is %d plus %d ?\n", num1, num2);
			break;
			
			case 2 : System.out.printf("How much is %d times %d ?\n", num1, num2);
			break;
			
			case 3 : System.out.printf("How much is %d minus %d ?\n", num1, num2);
			break;
			
			case 4 : System.out.printf("How much is %d divided by %d rounded to the nearest whole number?\n", num1, num2);
			break;
		}
		
	}
	

	
	static void isAnswerCorrect(double answer, int num1, int num2, int type) {
		switch (type) {
			case 1 : if(answer == num1 + num2) {
						displayCorrectResponse();
					}
			break;
			case 2 : if(answer == num1 * num2) {
						displayCorrectResponse();
					}
			break;
			case 3 : if(answer == num1 - num2) {
						displayCorrectResponse();
					}
			break;
			case 4 : if(answer == Math.round((double)num1 / (double)num2)) {
						displayCorrectResponse();
					}
			break;
			
			default: displayIncorrectResponse();
		}
	}
	static void displayCompletionMessage() {
		double score = ((double)numCorrect / 10) * 100;
		System.out.printf("Your score is %.2f", score);
		if(numCorrect < 8) System.out.println("Please ask your teacher for extra help.");
		else System.out.println("Congratulations! You are ready to go to the next level");
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
	
	static void generateQuestionArgument(int difficulty) {
		switch(difficulty) {
		case 1: num1 = random.nextInt(10);
				num2 = random.nextInt(10);
				break;
		case 2: num1 = random.nextInt(100);
				num2 = random.nextInt(100);
				break;
		case 3: num1 = random.nextInt(1000);
				num2 = random.nextInt(1000);
				break;
		case 4: num1 = random.nextInt(10000);
				num2 = random.nextInt(10000);
				break;
		}
	}
	
	static int readDifficulty() {
		int difficulty;
		System.out.println("Please enter a difficulty level. (1-4)");
		difficulty = input.nextInt();
		return difficulty;
	}
	
	static int readProblemType() {
		int type;
		System.out.println("Please enter the type of problem you want.");
		System.out.println("1 = +, 2 + *, 3 = =, 4 + /, 5 = random");
		type = input.nextInt();
		return type;
	}
}
