class Snack(val id: Long, val name: String, val cost: Double, var quantity: Long){

    fun removeQuantity(vendQuant: Long): Boolean {
        val quantLeft = quantity - vendQuant
        if(quantLeft > 0){
            quantity = quantLeft
            return true
        } else {
            println("Can not vend $vendQuant for $name. Reselect amount.")
            return false
        }
    }

    fun restock(toRestock: Long){
        println("Restocking $name.\nCurrent amount: $quantity")
        quantity += toRestock
        println("Amount after adding: $quantity")
    }

}