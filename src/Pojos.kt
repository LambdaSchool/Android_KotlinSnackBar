
class Snack(val id: Int,
            var name: String,
            quantity: Int = 0,
            val cost: Double,
            val vendingMachineId: Int) {

    var quantity: Int = quantity
    private set (value) {
        field = value
    }

    fun restockQuantity(amount: Int): Int {
        quantity += amount
        return quantity
    }

    fun buySnacks(amount: Int): Double {
        return if (amount <= quantity) {
            quantity = quantity.minus(amount)
            amount.times(cost)
        } else {
            -1.0
        }
    }

    fun getTotalCost(amount: Int): Double {
        return amount.times(cost)
    }
}

class VendingMachine(val id: Int, var name: String)

class Customer(val id: Int,
               var name: String,
               var cashOnHand: Double) {

    fun addCash(cashToAdd: Double) {
        cashOnHand += cashToAdd
    }

    fun buy(cashUsed: Double) {
        if (cashUsed > cashOnHand) {
            println("Not enougb money")
        } else {
            cashOnHand -= cashUsed
        }
    }

    fun isBroke(): Boolean {
        return cashOnHand <= 0
    }
}