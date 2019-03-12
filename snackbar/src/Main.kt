fun main(args: Array<String>) {

    val janeCustomer = Customer(1, "Jane", 45.25)
    val bobCustomer = Customer(2, "Bob", 33.14)

    val food = VendingMachine(1, "Food")
    val drink = VendingMachine(2, "Drink")
    val office = VendingMachine(3, "Office")

    val s1 = Snack(1, "Chips", 1.75, 36)
    val s2 = Snack(2, "Chocolate Bar", 1.00, 36)
    val s3 = Snack(3, "Pretzel", 2.00, 30)

    val d1 = Snack(4, "Soda", 2.50, 24)
    val d2 = Snack(5, "Water", 2.75, 20)

    food.addSnack(s1)
    food.addSnack(s2)
    food.addSnack(s3)

    drink.addSnack(d1)
    drink.addSnack(d2)

    drink.purchase(janeCustomer, d1, 3)




}


