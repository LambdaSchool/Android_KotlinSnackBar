fun main(args: Array<String>) {
    println("Hello World")
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