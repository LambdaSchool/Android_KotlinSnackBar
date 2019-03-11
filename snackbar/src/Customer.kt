class Customer(val id: Long, val name: String, var cash: Double) {


    fun spendMoney(spending: Double) {
        val remainingCash = cash - spending
        if(remainingCash > 0) {
            cash = remainingCash
            println("$name has spent $spending, and has $cash left.")
        } else {
            println("$name does not have enough money to spend $spending. " +
                    "\nBalance: $cash")
        }
    }
}