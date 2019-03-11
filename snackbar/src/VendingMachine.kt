class VendingMachine(val id: Long, val name: String) {

    private val inventory = ArrayList<Snack>()

    fun addSnack(toAdd: Snack){
        inventory.add(toAdd)
    }

}