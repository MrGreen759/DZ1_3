fun main() {
    var value: Int                  // сумма к переводу
    var fromCard: String            // тип карты, с которой переводят
    var toCard: String              // тип карты, на которую переводят
    var sentInMonth: Int = 0        // переведено за месяц

    value = 60000
    fromCard = "Visa"
    toCard = "VK Pay"
    println (comission(value, fromCard, toCard, sentInMonth))

    value = 60000
    fromCard = "Mastercard"
    toCard = "Visa"
    sentInMonth = 21000
    println (comission(value, fromCard, toCard, sentInMonth))

    value = 60000
    fromCard = "Мир"
    toCard = "Visa"
    println (comission(value, fromCard, toCard, sentInMonth))
}

fun comission (sum: Int, from: String, to: String = "VK Pay", sent: Int = 0): String {
    var comissionValue: Int = 0
    var result: String = ""

    if ((sent+sum) > 600000) result = "Превышен месячный лимит."
    else {
        when {
            to == "VK Pay" -> result = "Комиссия не взимается."
            (from == "Visa") || (from == "Мир") -> {
                comissionValue = (sum * 75) / 100
                if (comissionValue < 3500 ) comissionValue = 3500
                result = "Комиссия составит " + comissionValue.toString() + " копеек."
            }
            (from == "Mastercard") || (from == "Maestro") -> {
                if ((sent + sum) <= 75000) result = "Комиссия не взимается"
                else {
                    comissionValue = (sum * 6) / 10 + 2000
                    result = "Комиссия составит " + comissionValue.toString() + " копеек."
                }
            }
        }
    }
    return result
}
