import java.security.SecureRandom;
import java.util.Scanner;
public class CAI4 {
	private static Scanner input = new Scanner(System.in);
	private static int num1, num2, numCorrect = 0;
	private static	SecureRandom random = new SecureRandom();
	
	public static void main(String[] args) {
		quiz();
	}
	
	public static void quiz() {
		String yesNo;
		int difficulty = readDifficulty();
		for(int i = 0; i < 10; i++) {
			generateQuestionArgument(difficulty);
			askQuestion(num1, num2);
			int answer = readResponse();
			isAnswerCorrect(answer, num1, num2);
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
	
	static void askQuestion(int num1, int num2) {
		System.out.printf("How much is %d times %d ?\n", num1, num2);
	}
	

	
	static void isAnswerCorrect(int answer, int num1, int num2) {
		if(answer == num1 * num2) {
			displayCorrectResponse();
		}
		else displayIncorrectResponse();
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
}
