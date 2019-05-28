
fun main(args: Array<String>) {
    //Instances
    val customerJane = Customer(1, "Jane", 45.25)
    val customerBob = Customer(2, "Bob", 33.14)

    val foodMachine = VendingMachine(1, "Food")
    val drinkMachine = VendingMachine(2, "Drinks")
    val officeMachine = VendingMachine(3, "Office")

    val chipsSnack = Snack(1, "Chips", 36, 1.75, 1)
    val chocolateSnack = Snack(2, "Chocolate", 36, 1.00, 1)
    val pretzelSnack = Snack(3, "Pretzel", 30, 2.00, 1)

    val sodaDrink = Snack(4, "Soda", 24, 2.50, 2)
    val waterDrink = Snack(5, "Water", 20, 2.75, 2)

    //Processing
    performTransaction(customerJane, sodaDrink, 3)
    performTransaction(customerJane, pretzelSnack, 1)
    performTransaction(customerBob, sodaDrink, 2)
    customerJane.cashOnHand = customerJane.cashOnHand.plus(10.00)
    println("Jane found 10 dollars and now has ${customerJane.cashOnHand}")
    performTransaction(customerJane, chocolateSnack, 1)
    pretzelSnack.restockQuantity(12)
    println("12 pretzel snacks were added. There are now ${pretzelSnack.quantity} pretzel snacks")
    performTransaction(customerBob, pretzelSnack, 3)

}

fun performTransaction(customer: Customer, snack: Snack, quantity: Int) {
    if (!customer.isBroke() && snack.getTotalCost(quantity) <= customer.cashOnHand) {
        customer.buy(snack.buySnacks(quantity))
        println("${customer.name} has ${customer.cashOnHand} left after buying " +
                "$quantity ${snack.name} snacks")
        println("There are ${snack.quantity} ${snack.name} snacks left")
    }
}