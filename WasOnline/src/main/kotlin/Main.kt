fun main() {
    var timeAgo: Int

    timeAgo = 45
    println("Пользователь был в системе ${forOutput(timeAgo)}")

    timeAgo = 71 // 1 минута
    println("Пользователь был в системе ${forOutput(timeAgo)}")

    timeAgo = 122 // 2 минуты
    println("Пользователь был в системе ${forOutput(timeAgo)}")

    timeAgo = 235 // 4 минуты
    println("Пользователь был в системе ${forOutput(timeAgo)}")

    timeAgo = 665 // 11 минут
    println("Пользователь был в системе ${forOutput(timeAgo)}")

    timeAgo = 3622 // 1 час
    println("Пользователь был в системе ${forOutput(timeAgo)}")

    timeAgo = 11000 // 3 часа
    println("Пользователь был в системе ${forOutput(timeAgo)}")

    timeAgo = 21611 // 6 часов
    println("Пользователь был в системе ${forOutput(timeAgo)}")

    timeAgo = 87000 // вчера
    println("Пользователь был в системе ${forOutput(timeAgo)}")

    timeAgo = 173000 // позавчера
    println("Пользователь был в системе ${forOutput(timeAgo)}")

    timeAgo = 1_000_000 // более 11 дней, то есть давно
    println("Пользователь был в системе ${forOutput(timeAgo)}")
}

// возвращаем сформированную фразу
fun forOutput(sec:Int): String {
    val MINUTE = 60
    val HOUR = 3600
    val DAY = 86400
    val DAY2 = 172800
    val DAY3 = 259200

    when {
        sec < 0 -> return "давно"
        sec <= MINUTE -> return "только что"
        sec <= HOUR -> return minutes(sec)
        sec <= DAY -> return hours(sec)
        sec <= DAY2 -> return "вчера"
        sec <= DAY3  -> return "позавчера"
        else -> return "давно"
    }
}

// склоняем минуты, возвращаем готовую фразу
fun minutes(sec: Int): String {
    var min: Int = (Math.round(sec/60.0)).toInt()
    var word: String

    when {
        ( (min % 10 === 1) && (min % 100 != 11) ) -> word = " минуту"
        ( (min % 10 === 2 ) || (min % 10 === 3 ) || (min % 10 ===4) ) -> word = " минуты"
        else -> word = " минут"
    }
    return min.toString() + word + " назад."
}

// склоняем часы, возвращаем готовую фразу
fun hours(sec: Int): String {
    var hours: Int = (Math.round(sec/3600.0)).toInt()
    var word: String

    when {
        ( (hours % 10 === 1) && (sec % 100 != 11) ) -> word = " час"
        ( (hours % 10 === 2 ) || (hours % 10 === 3 ) || (hours % 10 ===4) ) -> word = " часа"
        else -> word = " часов"
    }
    return hours.toString() + word + " назад."
}