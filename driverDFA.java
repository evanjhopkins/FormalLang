import java.util.Scanner;

public class driverDFA {
	public static void main(String args[]) {
		Boolean isSolutionValid = false;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Propose Solution: ");
		String raw_input = scanner.nextLine();
		ManWolf mwInstance = new ManWolf();
		isSolutionValid = mwInstance.evaluate(raw_input);
	}
}