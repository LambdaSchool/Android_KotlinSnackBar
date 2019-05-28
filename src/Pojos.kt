class Snack(val id: Int,
            var name: String,
            quantity: Int = 0,
            val cost: Double,
            val vendingMachineId: Int) {

    var quantity: Int = quantity
    private set (value) {
        field = value
    }

    fun restockQuantity(amount: Int) {
        quantity += amount
    }

    
}