import java.util.*

fun main(args: Array<String>){
    val jane = Customer(1, "Jane", 45.25)
    val bob = Customer(2, "Bob", 33.14)

    val food = VendingMachine(1, "food")
    val drink = VendingMachine(2, "drink")
    val office = VendingMachine(3, "office")

    val chips = Snack(1, "Chips", 36, 1.75, 1)
    val chocolate = Snack(2, "Chocolate Bar", 36, 1.00, 1)
    val pretzel = Snack(3, "Pretzel", 30, 2.00, 1)

    val soda = Snack(1, "Soda", 24, 2.50, 2)
    val water = Snack(2, "Water", 20, 2.75, 2)

    var input = 0
    while (input != 3) {
        input = showMenu()
        when(input) {
            1 -> {
                println("What snack would you like to buy?")
                println("1. Chips $${chips.cost}, ${chips.getQuantity()} left")
                println("2. Chocolate Bar $${chocolate.cost}, ${chocolate.getQuantity()} left")
                println("3. Pretzel $${pretzel.cost}, ${pretzel.getQuantity()} left")
                val input = Scanner(System.`in`)
                when(input.nextInt()){
                    1 -> {
                        println("You bought one bag of chips")
                        bob.buySnack(chips.buySnack(1))
                        println("You have $${bob.cashOnHand} left")
                    }
                    2 -> {
                        println("You bought one chocolate bar")
                        bob.buySnack(chocolate.buySnack(1))
                        println("You have $${bob.cashOnHand} left")
                    }
                    3 -> {
                        println("You bought one pretzel")
                        bob.buySnack(pretzel.buySnack(1))
                        println("You have $${bob.cashOnHand} left")
                    }
                }
            }
            2 -> {
                println("What would you like to do?")
                println("1. Add snack quantity")
                val input = Scanner(System.`in`)
                when(input.nextInt()){
                    1 -> {
                        println("What snack do you want to add more of?")
                        println("1. Chips")
                        println("2. Chocolate Bar")
                        println("3. Pretzel $")
                        val input = Scanner(System.`in`)
                        when(input.nextInt()){
                            1 -> {
                                val intInput = Scanner(System.`in`)
                                println("How much do you want to add?")
                                if(intInput.nextInt() > 0){
                                    chips.addQuantity(intInput.nextInt())
                                    println("Added ${intInput.nextInt()} chips")
                                }
                            }
                            2 -> {
                                val intInput = Scanner(System.`in`)
                                println("How much do you want to add?")
                                if(intInput.nextInt() > 0){
                                    chocolate.addQuantity(intInput.nextInt())
                                    println("Added ${intInput.nextInt()} chocolate bars")
                                }
                            }
                            3 -> {
                                val intInput = Scanner(System.`in`)
                                println("How much do you want to add?")
                                if(intInput.nextInt() > 0){
                                    pretzel.addQuantity(intInput.nextInt())
                                    println("Added ${intInput.nextInt()} pretzels")
                                }
                            }
                        }
                    }
                }
            }
            3 -> {

            }
        }
    }
}

fun showMenu(): Int {
    var userInput = 0
    val input = Scanner(System.`in`)

    println("Who are you?")
    println("1. Customer")
    println("2. Manager")
    println("3.Quit")
    println("Enter your choice:")
    userInput = input.nextInt()

    return userInput

}

class Snack(val id: Int, var name: String, private var quantity: Int, var cost: Double, var vendingMachineId: Int){

    fun getQuantity(): Int{
        return quantity
    }

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
    var isBroke: Boolean = false
        set(isBroke) { cashOnHand <= 0.0}

    fun buySnack(totalCost: Double){
        cashOnHand -= totalCost
    }
}