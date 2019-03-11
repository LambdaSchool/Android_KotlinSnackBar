fun main(args: Array<String>){
    val jane = Customer(1, "Jane", 45.25)
    val bob = Customer(2, "Bob", 33.14)

    val food = VendingMachine(1, "food")
    val drink = VendingMachine(2, "drink")
    val office = VendingMachine(3, "office")

    val chips = Snack(1, "Chips", 36, 1.75, 1)
    val chocolate = Snack(2, "Chocolate Bar", 36, 1.00, 1)
    val pretzel = Snack(3, "Pretzel", 30, 2.00, 1)

    val soda = Snack(1, "Soda", 24, 2.50, 2)
    val water = Snack(2, "Water", 20, 2.75, 2)

    jane.buySnack(soda.buySnack(3))
    println("${jane.name} buys 3 soda, remaining cash: ${jane.cashOnHand}, soda left: ${soda.getQuantity()}")

    jane.buySnack(pretzel.buySnack(1))
    println("${jane.name} buys 1 pretzel, remaining cash: ${jane.cashOnHand}, pretzel left: ${pretzel.getQuantity()}")

    bob.buySnack(soda.buySnack(2))
    println("${bob.name} buys 2 soda, remaining cash: ${bob.cashOnHand}, soda left: ${soda.getQuantity()}")

    jane.cashOnHand += 10.0
    println("Jane has ${jane.cashOnHand}")

    jane.buySnack(chocolate.buySnack(1))
    println("${jane.name} buys 1 chocolate, remaining cash: ${jane.cashOnHand}, chocolate left: ${chocolate.getQuantity()}")

    pretzel.addQuantity(12)
    println("Pretzel in stock: ${pretzel.getQuantity()}")

    bob.buySnack(pretzel.buySnack(3))
    println("${bob.name} buys 3 pretzel, remaining cash: ${bob.cashOnHand}, pretzel left: ${pretzel.getQuantity()}")
}

class Snack(val id: Int, var name: String, private var quantity: Int, var cost: Double, var vendingMachineId: Int){

    fun getQuantity(): Int{
        return quantity
    }

    fun addQuantity(quantityToAdd: Int): Int{
        quantity += quantityToAdd
        return quantity
    }

    fun buySnack(quantityToBuy: Int): Double{
        quantity -= quantityToBuy
        return getTotalCost(quantityToBuy)
    }

    fun getTotalCost(quantity: Int): Double{
        return if(quantity <= this.quantity){
            quantity.times(cost)
        }else{
            0.0
        }
    }
}

class VendingMachine(val id: Int, var name: String)

class Customer(val id: Int, var name: String, var cashOnHand: Double){
    var isBroke: Boolean = false
        set(isBroke) { cashOnHand <= 0.0}

    fun buySnack(totalCost: Double){
        cashOnHand -= totalCost
    }
}