## Vending Machine Software

We've been asked to develop an application for the newest vending machine distributor,
Umbrella Corp. They've released a new vending machine, Vendo-Matic 800, that is integrated
with everyone's bank accounts, allowing customers to purchase products from their computers for their convenience.

### Application 

1. The vending machine dispenses beverages, candy, chips, and gum.
2. A main menu must display when the software runs:
    > ```
    > (1) Display Vending Machine Items
    > (2) Purchase
    > (3) Exit
    > ```
3. The vending machine inventory is stocked via an input file when the vending machine
starts.
4. The vending machine is automatically restocked each time the application runs.
5. When the customer selects "(1) Display Vending Machine Items", they're presented
with a list of all items in the vending machine with its quantity remaining:
    - Each vending machine product has a slot identifier and a purchase price.
    - Each slot in the vending machine has enough room for 5 of that product.
    - Every product is initially stocked to the maximum amount.
    - A product that has run out indicates that it is SOLD OUT.
6. When the customer selects "(2) Purchase", they are guided through the purchasing
process menu:
    >```
    >(1) Feed Money
    >(2) Select Product
    >(3) Finish Transaction
    >
    > Current Money Provided: $2.00
    >```
7. The purchase process flow is as follows:
    1. Selecting "(1) Feed Money" allows the customer to repeatedly feed money into the
    machine in valid, whole dollar amounts—for example, $1, $2, $5, or $10.
    2. Selecting "(2) Select Product" allows the customer to select a product to
    purchase.
        - It shows the list of products available and allows the customer to enter
        a code to select an item.
        - If the product code does not exist, the customer is informed and returned
        to the Purchase menu.
        - If a product is sold out, the customer is informed and returned to the
        Purchase menu.
        - If a valid product is selected, it is dispensed to the customer.
        - Dispensing an item prints the item name, cost, and the money
        remaining. Dispensing also returns a message:
          - All chip items print "Crunch Crunch, Yum!"
          - All candy items print "Munch Munch, Yum!"
          - All drink items print "Glug Glug, Yum!"
          - All gum items print "Chew Chew, Yum!"
        - After the product is dispensed, the machine updates its balance
        accordingly and returns the customer to the Purchase menu.
    3. Selecting "(3) Finish Transaction" allows the customer to complete the
    transaction and receive any remaining change.
        - The customer's money is returned using nickels, dimes, and quarters
        (using the smallest amount of coins possible).
        - The machine's current balance updates to $0 remaining.
    4. After completing their purchase, the user is returned to the "Main" menu to
    continue using the vending machine.
8. All purchases it's audited to prevent theft from the vending machine:
   - Each purchase generates a line in a file called `Log.txt`.
   - The audit entry is in the format:
        >```
        > 01/01/2016 12:00:00 PM FEED MONEY: $5.00 $5.00
         >01/01/2016 12:00:15 PM FEED MONEY: $5.00 $10.00
         >01/01/2016 12:00:20 PM Crunchie B4 $10.00 $8.50
         >01/01/2016 12:01:25 PM Cowtales B2 $8.50 $7.50
         >01/01/2016 12:01:35 PM GIVE CHANGE: $7.50 $0.00
         >```
9. Sales Report
    - On the main menu, there's a hidden option ("4") that writes to a sales
    report that shows the total sales since the machine was started. The name of the
    file includes the date and time so each sales report is uniquely named.

___
### About the project

This project was created by [Juliana Planas](https://github.com/julianaplanas) and [Julieta D'Angelo](https://github.com/JulietaDangelo) in the Tech Elevator program.
