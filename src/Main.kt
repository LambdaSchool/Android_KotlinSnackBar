fun main(args: Array<String>){
    val snack = Snack(1, "Cookie", 10, 2.0, 1)

}

class Snack(val id: Int, var name: String, private var quantity: Int, var cost: Double, var vendingMachineId: Int){

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
     fun buySnack(totalCost: Double){
         cashOnHand -= totalCost
     }
}