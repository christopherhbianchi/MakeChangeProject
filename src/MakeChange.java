import java.util.Scanner;
import static java.lang.System.*;


public class MakeChange {
	
static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
		
		double itemPrice, amtTendered;
		double amountBack;
		int twentiesBack, tensBack, fivesBack;
		boolean correctAMT = true;
		
		
		
		itemPrice = GetItemPrice();
		amtTendered = GetAmtTendered();
		amtTendered = MoneyChecker(itemPrice, amtTendered);
		amountBack = AmountBack(itemPrice, amtTendered);
		twentiesBack = TwentiesBack(amountBack);
		tensBack = TensBack(amountBack, twentiesBack);
		fivesBack = FivesBack(amountBack, twentiesBack, tensBack);
		
		
		
		
				
		
	}

}

	public static double GetItemPrice() {
		double itemPrice;
		
		out.print("What is the price of the item?: ");
		itemPrice = keyboard.nextDouble();
		return itemPrice;
}
	
	public static double GetAmtTendered() {
		double amtTendered;
		
		out.print("How much money was tendered by the customer?: ");
		amtTendered = keyboard.nextDouble();
	}
	
	public static double MoneyChecker(double itemPrice, double amtTendered) {
		
		do {
		
			if (amtTendered < itemPrice ) {
				err.println("The customer didn't pay enough money. Ask him for more. ");
				out.print("What is the new amount tendered?: ");
				amtTendered = keyboard.nextDouble();
			}
			else if(amtTendered == itemPrice) {
				out.println("That's the correct amount. ");
			}
			else {
				out.println("That's too much money. Let's make change. ");
			}
		} while (amtTendered < itemPrice );
		
		return amtTendered;
	}
	
	public static void ChangeMaker() {
		
	}
	
	public static double AmountBack(double itemPrice, double amtTendered) {
		
		double amountBack;
		amountBack = amtTendered - itemPrice;
		return = amountBack;
	}
				
	
	//I changed the return type to Int so it would truncate off the decimal
	//we need to return a value because then we can use it to determine the 10s and 5s and so on
	public static int TwentiesBack(double amountBack) {			
				
				int twentiesBack;
				
				twentiesBack = amountBack / 20;
				return twentiesBack;
	}
	
	public static int TensBack(double amountBack, int twentiesBack) {
		
				int tensBack;
				
				tensBack = (amountBack - (twentiesBack * 20))/10;
				return tensBack;
	}
	
	public static int FivesBack(double amountBack, int twentiesBack, int tensBack) {
				
				int fivesBack;
				
				fivesBack = (amountBack - (twentiesBack * 20) - (tensBack * 10))/5;
				return fivesBack;
	}
		
		
		
		
				
				//Math.floor((amtTendered - itemPrice) * 100)/100;
		
		
		//for 20 dollar bills
		if (dollarsReturned % 20.0 != 0) {
			
		
		
		
		
		return dollarsReturned;
		
	}
}
		
		
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	