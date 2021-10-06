import java.util.Scanner;

/** 
 * Static functions used to check console input for validity.
 *
 * Use:	Place CheckInput class in the same project folder as your code.
 *	Call CheckInput functions from your code using "CheckInput."
 *
 * Example:  int num = CheckInput.getInt();
 *
 * @author Shannon Cleary 2021
 */
public class CheckInput {
	
	/**
	 * Checks if the inputted value is an integer.
	 * @return the valid input.
	 */
	public static int getInt() {
		Scanner in = new Scanner( System.in );
		int input = 0;
		boolean valid = false;
		while( !valid ) {
			if( in.hasNextInt() ) {
				input = in.nextInt();
				valid = true;
			} else {
				in.next(); //clear invalid string
				System.out.println( "Invalid Input." );
			}
		}
		return input;
	}
	
	/**
	 * Checks if the inputted value is an integer and 
	 * within the specified range (ex: 1-10)
	 * @param low lower bound of the range.
	 * @param high upper bound of the range.
	 * @return the valid input.
	 */
	public static int getIntRange( int low, int high ) {
		Scanner in = new Scanner( System.in );
		int input = 0;
		boolean valid = false;
		while( !valid ) {
			if( in.hasNextInt() ) {
				input = in.nextInt();
				if( input <= high && input >= low ) {
					valid = true;
				} else {
					System.out.println( "Invalid Range." );
				}
			} else {
				in.next(); //clear invalid string
				System.out.println( "Invalid Input." );
			}
		}
		return input;
	}
	/**
	 * Checks if the inputted value is a non-negative integer.
	 * @return the valid input.
	 */
	public static int getPositiveInt( ) {
		Scanner in = new Scanner( System.in );
		int input = 0;
		boolean valid = false;
		while( !valid ) {
			if( in.hasNextInt() ) {
				input = in.nextInt();
				if( input >= 0 ) {
					valid = true;
				} else {
					System.out.println( "Invalid Range." );
				}
			} else {
				in.next(); //clear invalid string
				System.out.println( "Invalid Input." );
			}
		}
		return input;
	}

	/**
	 * Checks if the inputted value is a double.
	 * @return the valid input.
	 */
	public static double getDouble() {
		Scanner in = new Scanner( System.in );
		double input = 0;
		boolean valid = false;
		while( !valid ) {
			if( in.hasNextDouble() ) {
				input = in.nextDouble();
				valid = true;
			} else {
				in.next(); //clear invalid string
				System.out.println( "Invalid Input." );
			}
		}
		return input;
	}
	
	/**
	 * Takes in a string from the user.
	 * @return the inputted String.
	 */
	public static String getString() {
		Scanner in = new Scanner( System.in );
		String input = in.nextLine();
		return input;
	}

	/**
	 * Takes in a yes/no from the user.
	 * @return true if yes, false if no.
	 */
	public static boolean getYesNo(){
		boolean valid = false;
		while( !valid ) {
			String s = getString();
			if( s.equalsIgnoreCase("yes") || s.equalsIgnoreCase("y") ) {
				return true;
			} else if( s.equalsIgnoreCase("no") || s.equalsIgnoreCase("n") ) {
				return false;
			} else {
				System.out.println( "Invalid Input." );
			}
		}
		return false;
	}

	/**
	 * Takes in a string that has a dollar sign.
	 * Removes the $ symbol and adds the value into a double
	 * @return the double without the dollar sign.
	 * **/
	public static double checkDollarSign() {
		Scanner in = new Scanner(System.in);
		boolean isRunning = true;
		while (isRunning) {
			if (in.hasNextDouble()) {
				System.out.println("the user inputted a double");
				double amount = in.nextDouble();
				isRunning = false;
				return amount;
			}
			if (in.hasNextLine()) {
				String input = in.nextLine();
				char[] stringToInt = new char[input.length()];
				if (input.charAt(0) == '$') {
					for (int i = 0; i < input.length() - 1; i++) {
						stringToInt[i] = input.charAt(i + 1);
					}
					try {
						String s = String.valueOf(stringToInt);
						double amount = Double.parseDouble(s);
						isRunning = false;
						return amount;
					} catch (Exception e) {
						System.out.println("\n-----------------------------------------------------------------------------");
						System.out.println("Invalid Input");
						System.out.println("Please input with the correct format: [ $(amount) ]");
						System.out.println("-----------------------------------------------------------------------------");
						System.out.print("Amount: ");
					}
				} else {
					System.out.println("\n-----------------------------------------------------------------------------");
					System.out.println("Invalid Input");
					System.out.println("Please input with the correct format: [ $(amount) ]");
					System.out.println("-----------------------------------------------------------------------------");
					System.out.print("Amount: ");
				}
			}
		}
		return 0;
	}
}