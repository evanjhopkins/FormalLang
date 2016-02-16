import java.util.Scanner;

public class driverDFA {
	public static void main(String args[]) {
		boolean solutionIsValid = false;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Propose Solution: ");
		String raw_input = scanner.nextLine();
		ManWolf mwInstance = new ManWolf();
		solutionIsValid = mwInstance.evaluate(raw_input);

		if(solutionIsValid) {
			System.out.println("That is a solution.");
		}else{
			System.out.println("That is not a solution.");
		}
	}
}
