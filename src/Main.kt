fun main(args: Array<String>){
    val snack = Snack(1, "Cookie", 10, 2.0, 1)

}

class Snack(val id: Int, var name: String, var quantity: Int, var cost: Double, var vendingMachineId: Int){

    fun addQuantity(quantityToAdd: Int): Int{
        quantity += quantityToAdd
        return quantity
    }

    fun buySnack(quantityToBuy: Int): Int{
        quantity -= quantityToBuy
        return quantity
    }

    fun getTotalCost(quantity: Int): Double{
        return if(quantity <= this.quantity){
            quantity.times(cost)
        }else{
            0.0
        }
    }
}