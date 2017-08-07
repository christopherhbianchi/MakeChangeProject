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

Second, I created the BillsAndCoinsBack function as a way to calculate each of the number of bills that needed to be returned to the customer, and storing them in the billsAndCoinsBack array at the i'th position, with i being a counter variable starting at 0. For inputs, I not only input that array, but I also included the amountBack2 variable which is equal to the amountBack variable, multiplied by 100 to get the total amount of change into pennies. This I believed was the most efficient way to calculate all the denominations of bills, and all of my calculations were done in pennies. Third, I wrote in the calculation starting at the highest denomination (twenties). The amount back in pennies divided by $20 in pennies (2000) was equal to the number of twenty dollar bills that needed to be returned for change. I then used modulus to store the remainder in a variable named change, and then incremented i by 1 so that the next value stored could be the next spot in the array for the number of bills. Third, I did the same process with the ten dollar bills except that for the second change calculation, I set change equal to itself divided by 1000. This was done so that the remainder in pennies after taking away the previous bill can continually be stored in change and carried out all the way through to calculating the number of pennies. 

Fourth, I created a method using i as a counter variable to print out the number of bills, but only if there was a value greater than 0 for them. So if there were no $5 bills returned, it wouldn't say "0 fives,". I also set up conditional statements that would only print a comma if i was less than 7 and the value at the array for the i'th spot wasn't 0 and i wasn't 0, the array at the previous i slot wasn't 0 as well. Fifth, we set a condition that said to enter a space if the previous array slot had a value that wasn't 0 and it wasn't the 7th slot in the array (we don't want any spaces coming after pennies or if there wasn't a value output). Finally, given the condition for the comma already established, we just created a statement that prints a period when you get to the last slot in the array. It doesn't matter whether or not the penny slot had anything, this just places the period down after it has finished reading the array.




