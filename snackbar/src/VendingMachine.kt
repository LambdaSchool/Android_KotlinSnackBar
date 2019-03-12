class VendingMachine(val id: Long, val name: String) {

    private val inventory = ArrayList<Snack>()

    fun addSnack(toAdd: Snack){
        inventory.add(toAdd)
    }

    fun purchase(customer: Customer, snack: Snack, quantity: Long) {
        val selectedSnack: Snack = inventory.filter { s-> s.name == snack.name }.single()
        val isStocked: Boolean = snack.removeQuantity(quantity)
        if(isStocked) {
            val amountChargd = snack.cost * quantity
            if(customer.cash > amountChargd) {
                println("Vending $quantity of ${snack.name} at $$amountChargd.")
                customer.spendMoney(amountChargd)
                snack.removeQuantity(quantity)
            }
        } else{
            println("Can not vend $quantity for ${selectedSnack.name}. Reselect amount.")
        }
    }
}