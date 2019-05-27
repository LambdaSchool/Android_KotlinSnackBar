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

}

class Snack(val id: Int, var name: String, private var quantity: Int, var cost: Double, val vmId: Int){
    fun addQuantity(addedQuantity: Int){
        quantity.plus(addedQuantity)
    }

    fun buySnack(amountBought: Int): Double{
        quantity.minus(amountBought)
        return amountBought.times(cost)
    }

    fun getTotalCost(): Double{
        return quantity.times(cost)
    }
}

class VendingMaching(var name: String, val id: Int)

class Customer(val id: Int, val name: String, var cashOnHand: Double){
    fun addCash(addedCash: Double){
        cashOnHand.plus(addedCash)
    }

    fun buy(cost: Double){
        cashOnHand.minus(cost)
    }
    val isBroke: Boolean
        get() = cashOnHand <= 0.0

}