import java.util.Scanner;
import static java.lang.System.*;

public class MakeChange2 {

	static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {

		double itemPrice, amtTendered;
		double amountBack;
		int amountBack2;

		int[] billsAndCoinsBack = new int[8];
		String[] billsAndCoins = { "twenties", "tens", "fives", "ones", "quarters", "dimes", "nickels", "pennies" };

		for (int i = 0; i < 5; i++) {

			itemPrice = GetItemPrice();
			amtTendered = GetAmtTendered();
			amtTendered = MoneyChecker(itemPrice, amtTendered);
			amountBack = AmountBack(itemPrice, amtTendered);
			amountBack2 = (int) (amountBack * 100); // puts it into pennies to make calculation smoother, store in new
													// variable since we
													// want the number of bills to be in ints.
			BillsAndCoinsBack(amountBack2, billsAndCoinsBack);
			ChangeStated(itemPrice, amtTendered, amountBack2, billsAndCoinsBack, billsAndCoins);

		}

		out.println("Okay, that's enough change making for today");

	}

	public static double GetItemPrice() {
		double itemPrice;

		out.print("\nWhat is the price of the item?: ");
		itemPrice = keyboard.nextDouble();
		return itemPrice;
	}

	public static double GetAmtTendered() {
		double amtTendered;

		out.print("How much money was tendered by the customer?: ");
		amtTendered = keyboard.nextDouble();

		return amtTendered;
	}

	public static double MoneyChecker(double itemPrice, double amtTendered) {

		do {

			if (amtTendered < itemPrice) {
				err.println("The customer didn't pay enough money. Ask him for more. ");
				out.print("What is the new amount tendered?: ");
				amtTendered = keyboard.nextDouble();
			} else if (amtTendered == itemPrice) {
				out.println("That's the correct amount. ");
			} else {
				out.println("That's too much money. Let's make change. ");
			}
		} while (amtTendered < itemPrice);

		return amtTendered;
	}

	public static double AmountBack(double itemPrice, double amtTendered) {

		double amountBack;
		amountBack = amtTendered - itemPrice;
		return amountBack;
	}

	public static void BillsAndCoinsBack(int amountBack2, int billsAndCoinsBack[]) {

		int change;
		int i = 0;

		billsAndCoinsBack[i] = amountBack2 / 2000;
		change = amountBack2 % 2000;
		i++;// have to put i++ outside if statements because we don't want it to depend on
			// whether or not the person
			// was going to get any bills back of a certain denomination or not... (if no
			// 20s back the program wouldn't
			// increment up

		billsAndCoinsBack[i] = change / 1000; // so we store the number of bills in the i'th spot of the array
		change = change % 1000; // then if there's a remainder we store it in a change variable
		i++; // then we use that remaining change to see if the next denomination down fits
				// into it
		// and again, if there's a remainder we store it in change again so that we can
		// keep going down the line
		billsAndCoinsBack[i] = change / 500; // of coin/bill denominations and then re-storing them
		change = change % 500; // we do i++ at the end each time so we can then store the next denomination
								// into the next slot of the array
		i++;

		billsAndCoinsBack[i] = change / 100;
		change = change % 100;
		i++;

		billsAndCoinsBack[i] = change / 25;
		change = change % 25;
		i++;

		billsAndCoinsBack[i] = change / 10;
		change = change % 10;
		i++;

		billsAndCoinsBack[i] = change / 1000;
		change = change % 5;
		i++;

		billsAndCoinsBack[i] = change / 1;
		change = change % 1;
		i++;

	}

	public static void ChangeStated(double itemPrice, double amtTendered, int amountBack2, int billsAndCoinsBack[],
			String billsAndCoins[]) {

		int i = 0;
		out.print("Amount: " + itemPrice + ",\tTendered: " + amtTendered + ",\tResult: ");

		do {

			if (i < (billsAndCoinsBack.length - 1) && billsAndCoinsBack[i] != 0 && i != 0
					&& billsAndCoinsBack[i - 1] != 0) {
				out.print(", ");
			}

			if (billsAndCoinsBack[i] != 0 && i != (billsAndCoinsBack.length - 1)) {
				out.print(billsAndCoinsBack[i] + " " + billsAndCoins[i]);
			}

			if (i == (billsAndCoinsBack.length - 1)) { // this lets us put the period at the end of the loop. We know
														// the largest
				out.println("."); // array slot is the 7th slot, so if i is 7, we know its the end, and put a
									// period.
			}

			i++;

		} while (i < 8); //could have just made this (billsAndCoinsBack.length - 1) but this makes the logic easier to 
						//understand looking back at it at this point.
	}

}
