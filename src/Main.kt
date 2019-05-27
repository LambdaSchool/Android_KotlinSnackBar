fun main(args: Array<String>) {
    println("Hello World")

    val Jane = Customer(1, "Jane", 45.25)
    val Bob = Customer(2, "Bob", 33.14)
    val FoodVM = VendingMaching("Food", 1)
    val DrinkVM = VendingMaching("Drink", 2)
    val OfficeVM = VendingMaching("Office", 3)
    val Chips = Snack(1, "Chips", 36, 1.75, 1)
    val ChocolatBar = Snack(2, "Chocolate Bar", 36, 1.00, 1)
    val Pretzel = Snack(3, "Pretzel", 30, 2.00, 1)
    val Soda = Snack(4, "Soda", 24, 2.50, 2)
    val Water = Snack(5, "Water", 20, 2.75, 2)

    Jane.buy(Soda.buySnack(3))
    println(Jane.cashOnHand)
    println(Soda.quantity)

    Jane.buy(Pretzel.buySnack(1))
    println(Jane.cashOnHand)
    println(Pretzel.quantity)

    Bob.buy(Soda.buySnack(2))
    println(Bob.cashOnHand)
    println(Soda.quantity)

    Jane.addCash(10.0)
    println(Jane.cashOnHand)

    Jane.buy(ChocolatBar.buySnack(1))
    println(Jane.cashOnHand)
    println(ChocolatBar.quantity)

    Pretzel.addQuantity(12)
    println(Pretzel.quantity)

    Bob.buy(Pretzel.buySnack(3))
    println(Bob.cashOnHand)
    println(Pretzel.quantity)
}

class Snack(val id: Int, var name: String, var quantity: Int, var cost: Double, val vmId: Int){
    fun addQuantity(addedQuantity: Int){
        quantity = quantity.plus(addedQuantity)
    }

    fun buySnack(amountBought: Int): Double{
        quantity = quantity.minus(amountBought)
        return amountBought.times(cost)
    }

    fun getTotalCost(): Double{
        return quantity.times(cost)
    }
}

class VendingMaching(var name: String, val id: Int)

class Customer(val id: Int, val name: String, var cashOnHand: Double){
    fun addCash(addedCash: Double){
        cashOnHand = cashOnHand.plus(addedCash)
    }

    fun buy(cost: Double){
        cashOnHand = cashOnHand.minus(cost)
    }
    val isBroke: Boolean
        get() = cashOnHand <= 0.0

}