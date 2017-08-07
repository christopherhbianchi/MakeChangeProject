#Christopher Bianchi SD 12
#Make Change Project


##Overview

The Make Change project is my week 1 take home project. The premise of the project was to create a program
that prompts a cashier (user) at a store for how much money an item cost, and displaying appropriate responses 
to payment types and amounts of bills and coins to be returned. 


##Requirements

The developed program satisfies each of the following
requirements:

1. Prompting the user for the price of an item
2. Prompting the user for how much money was tendered
3. Displaying an appropriate message if the customer didn't pay enough, paid more than enough, or the exact amount
4. Displaying the appropriate total to be returned with a breakdown of how many bills and coins, given they paid too much


##The Code

I wrote several methods to accomplish each of the tasks above. First, I created a couple of method to prompt the user for the
price of the item, the amount that was tendered for the item, and the amount that needs to be returned in change. Each of these methods
returned values necessary for the execution of the rest of the code, and they were stored in appropriate variables.

Second, I focused on returning back the appropriate number of bills. To achieve this, I created a method that takes the floor of the amountBack
variable that was storing the appropriate value to be returned to the customer. Since amountBack was a double variable, in order to account for the
cents that would accompany the dollars, I had to typecast the calculation for the Math.floor function since the Math methods do not work on double
data types. With the floor of the amount of change that needed to be returned, I focused on returning the appropriate amount of dollars.

Third, working with the dollars to be returned was easier since we had the floor of the total amount of change. I created methods to return each of the total amount of each bill that needed to be returned to the customer, stored the return values in new int variables, and then used those returned values for inputs for the next method down. So the process could repeat itself for each method down the line. The calculations within each of those methods all went the same way. Starting with the number of twenties to be returned, I took the amountBackFloor variable and divided it by 20. Since the twentiesBack variable is an int, it would automatically cut off any remainders, leaving only the number of twenties to be returned for the appropriate tendered amount. From there, I would take the amountBackFloor and subtract the number of the bill to be returned less the value of the bill, and then divide that value by the value of the next bill down. Doing so would continue to provide the total number of bills of each type to return. Each bill determining method pointed back to the returned value of the highest bill above it. Fourth, I followed a similar process for determining how many of each coin to be returned.

Fifth, I created an int array that stored the 8 values of bills and coins to be returned (twenties, tens, ..., nickels, and pennies). I also created a String array that actually held the String values saying the type of bills ("twenties", "tens", ..., "nickels", and "pennies"). Using both of these arrays as inputs, I created a method that then would state the amount of change to be returned as well as a breakdown of how many each bill needed to be handed back, with appropriate punctuation and spaces (we don't want there to be a comma and a period next to each other). For this, I used if statements with counter variables that checked conditions to make sure it only printed out a value if there was actually an amount of that value to be returned, making sure it didn't count past "7" array slots, and more.

Finally, I put the entire block of code within the main method into a while loop that would allow the program to continually run and prompt the user for item prices, amount tendered, and appropriate change to be returned. 


