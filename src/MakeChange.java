import java.util.Scanner;
import static java.lang.System.*;


public class MakeChange {
	
static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
		
		double itemPrice, amtTendered;
		double amountBack;
		int amountBackFloor, centsBack; //had to make int to do the floor function on it for all my bill calculations
		int twentiesBack, tensBack, fivesBack, onesBack;
		int quartersBack, dimesBack, nickelsBack, penniesBack; //we are working with whole numbers for these... after we give
		boolean infiniteLoopVariable = true;				//the total change amount (like 5.73) we never work in decimals again
		
		while(infiniteLoopVariable) {  //this was done last and lets people enter amounts as many times as they want
		
		itemPrice = GetItemPrice();
		amtTendered = GetAmtTendered();
		amtTendered = MoneyChecker(itemPrice, amtTendered);
		amountBack = AmountBack(itemPrice, amtTendered);
		amountBackFloor = (int)Math.floor(amountBack);
		centsBack = CentsBack(amountBack, amountBackFloor);
		twentiesBack = TwentiesBack(amountBackFloor);
		tensBack = TensBack(amountBackFloor, twentiesBack);
		fivesBack = FivesBack(amountBackFloor, twentiesBack, tensBack);
		onesBack = OnesBack(amountBackFloor, twentiesBack, tensBack, fivesBack);
		quartersBack = QuartersBack(centsBack);
		dimesBack = DimesBack(centsBack, quartersBack);
		nickelsBack = NickelsBack(centsBack, quartersBack, dimesBack);
		penniesBack = PenniesBack(centsBack, quartersBack, dimesBack, nickelsBack);
		
		int[] billsArray = {twentiesBack, tensBack, fivesBack, onesBack, 
				quartersBack, dimesBack, nickelsBack, penniesBack};
		String[] billsAndCoins = {"twenties", "tens", "fives", "ones", "quarters",
				"dimes", "nickels", "pennies"};
		
		ChangeStated(amountBack, amtTendered, billsArray, billsAndCoins);
		
		}
	}
		
		
//had to typecast amountBackFloor so the Math.floor function could be performed on it since
//doubles can't use the .Math method
//so we used amountBackFloor for all of the whole bill calculations because they're whole numbers (ints)..
//we can't have 1.2 ten dollar bills... so we get them into an int early just so it's possible for our methods
//to work with the amount back as an int since all the bills are ints
//we can use the regular amountBack variable to determine the change... and we can use similar math as we did with
//the dollar bills... just we will need to do it up to 25 cents being the biggest.
	



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
	
	
	public static double AmountBack(double itemPrice, double amtTendered) {
		
		double amountBack;
		amountBack = amtTendered - itemPrice;
		return amountBack;
	}
				
	
	//I changed the return type to Int so it would truncate off the decimal
	//we need to return a value because then we can use it to determine the 10s and 5s and so on
	public static int TwentiesBack(int amountBackFloor) {			
				
				int twentiesBack;
				
				twentiesBack = amountBackFloor / 20;
				return twentiesBack;
	}
	
//this calculation is a little different... so to figure out how many tens we need we need to take the floor value,
//subtract the number of 20s (times 20 since it's 1 $20 bill... but the calculation without it would just do
//amountBackFloor - 1 or something if our amount we had to give back only had 1 $20 bill in it...
//	
//	
	public static int TensBack(int amountBackFloor, int twentiesBack) {
		
				int tensBack;
				
				tensBack = (amountBackFloor - (twentiesBack * 20))/10;
				return tensBack;
	}
	
	public static int FivesBack(int amountBackFloor, int twentiesBack, int tensBack) {
				
				int fivesBack;
				
				fivesBack = (amountBackFloor - (twentiesBack * 20) - (tensBack * 10))/5;
				return fivesBack;
	}
	
	public static int OnesBack(int amountBackFloor, int twentiesBack, int tensBack, int fivesBack) {
				int onesBack;
				
				onesBack = (amountBackFloor - (twentiesBack * 20) - (tensBack * 10) - (fivesBack * 5))/1;
				return onesBack;
	}
		
	
	public static int CentsBack(double amountBack, int amountBackFloor) {
				int centsBack;
				
				//didn't need to typecast for some reason
				//the * 100 is because to start saying quarters and stuff we can work with whole numbers again
				//we're saying 1 quarter... not 1 25 cents, etc. so this will help later calculations.
				//by typecasting here, we make it so the rest of the quarter, dime, etc. functions won't need to be
				//typecast every time like we would if we left centsBack being a double variable with those
				// variable being ints.
				centsBack = (int)(100 * (amountBack - amountBackFloor));
				return centsBack;
	}
	
	public static int QuartersBack(int centsBack) {
				int quartersBack;
				
				quartersBack = (centsBack/25);
				return quartersBack;
	}
	
	
	public static int DimesBack(int centsBack, int quartersBack) {
				int dimesBack;
		
				dimesBack = (centsBack - (quartersBack * 25))/10;
				return dimesBack;
	}
	
	public static int NickelsBack(int centsBack, int quartersBack, int dimesBack) {
				int nickelsBack;
				
				nickelsBack = (centsBack - (quartersBack * 25) - (dimesBack * 10))/5;
				return nickelsBack;						
	}
	
	
	public static int PenniesBack(int centsBack, int quartersBack, int dimesBack, int nickelsBack) {
				int penniesBack;
				
				penniesBack = (centsBack - (quartersBack * 25) - (dimesBack * 10) - (nickelsBack * 5))/1;
				return penniesBack;
	}
	
	
	public static void ChangeStated(double amountBack, double amtTendered, int billsArray[], String billsAndCoins[]){
		int i = 0;
		int j = 0;
		
		out.println("Amount: " + amountBack + "\tTendered: " + amtTendered + "\tResult: ");
		do {
			
	//the conditions in this if were interesting. had to put the comma up top like this
	//because if i left it at the end you could have gotten a weird ", ." , so we had to put it before
	//the bill was said
	//also, we had to specify that okay i can't be 7(because we dont wan't to get a comma after penny)
	//you can't print it if there's no value in that slot of the billsArray
	//the previous slot in the array wasn't empty (since that would give us a comma output even if no twenties or
	//something was made
	//but last, what about for the 0th slot in the array? with that condition, we would get an error at the 0th
	//slot because 0-1 would have told the program to pull the -1th array slot which doesn't exist, and it would've
	//crashed...
	//so since we know &&'s get read from left to right, and that they're those quick read operators (if 1st operand false 
	//it stops immediately, we put that condition BEFORE it so that if i was at 0, it would stop reading early,
	//so it wouldn't get to that final condition and break the code.
			
			
			if( i < 7 && billsArray[i] !=0 && i != 0 && billsArray[i-1] != 0) {
				out.print(", ");
			}
			
			if(billsArray[i] != 0 && i != 7) {
			out.print(billsArray[i] + " " + billsAndCoins[j]);
			}
						
			
			if(i == 7) {				//this lets us put the period at the end of the loop. We know the largest	
				out.println(".");	//array slot is the 7th slot, so if i is 7, we know its the end, and put a period.
			}						//"println" so that it moves down to next line after, since the period comes at the end
			
			i++;
			j++;
			
		} while	(i < 8); //less than 8 is fine. Yes there's 8 slots, but it counts 0-7 so that's perfect.
	}
	
}

		
				
		
	

		
		
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	