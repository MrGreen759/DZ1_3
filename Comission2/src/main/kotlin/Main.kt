fun main() {
    var value: Int                  // сумма к переводу
    var fromCard: String            // тип карты, с которой переводят
    var toCard: String              // тип карты, на которую переводят
    var sentInMonth: Int = 0        // переведено за месяц

    //println("Комиссия за перевод составит ${comission(value, fromCard, toCard)} копеек.")

}

fun comission (sum: Int, from: String, to: String, sent: Int): String {
    var comissionValue: Int = 0
    var result: String

    if ((sent+sum) > 600000) result = "Превышен месячный лимит."
    else {
        when {
            to == "VK Pay" -> result = "Комиссия не взимается."
            (from == "Visa") || (from == "Мир") -> {
                comissionValue = (sum * 75) / 10000
                if (comissionValue < 3500 ) comissionValue = 3500
            }
            (from == "Mastercard") || (from == "Maestro") -> {

            }
        }
    }


}

fun checkLimit (sum: Int, from: String = "VK Pay", sentInMonth: Int, sentInDay: Int): Boolean {
    if (from == "VK Pay") {
        if (sum > 15000) return false
        if ((sentInDay+sum) > 40000) return false
        return true
    }
    if ((sentInDay + sum) > 150000) return false
    if ((sentInMonth + sum) > 600000) return false
    return true
}
