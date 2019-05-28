
fun main(args: Array<String>) {
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
}