class Snack(val id: Long, val name: String, val cost: Long, var quantity: Long){

    fun removeQuantity(vendQuant: Long){
        val quantLeft = quantity - vendQuant
        if(quantLeft > 0){
            quantity = quantLeft
        } else {
            println("Can not vend $vendQuant $name. Reselect amount.")
        }
    }

    fun restock(toRestock: Long){
        
    }

}