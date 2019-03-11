class VendingMachine(val id: Int, val name: String) {

    fun printId() = "This vending machines id is $id"

    fun printName() = "This vending machines name is $name"

}

class Snack(val id: Int, val name: String, private var quantity: Int, var cost: Double, val vendingMachineID: Int) {

    fun getQuantity() = "the quantity of $name is now $quantity"

    fun addQuantity(num: Int): String {
        quantity += num
        return "quantity is now $quantity"
    }

    fun buySnack(num: Int): Double {
        quantity -= num
        return cost.times(num)
    }

    fun getCost(num: Int): String {
        return "the cost of $num of these is: ${cost.times(num)}"
    }
}

class Customer(val id: Int, val name: String, var cash: Double) {

    fun addCash(num: Double): String {
        cash += num
        return "$name now has $cash on hand"
    }

    fun buySnacks(cost: Double): String {
        cash -= cost
        return "$name still has $cash left on hand"
    }

    fun sayName() = "my name is $name"

    fun checkWallet() = "$name has $cash on hand"
}