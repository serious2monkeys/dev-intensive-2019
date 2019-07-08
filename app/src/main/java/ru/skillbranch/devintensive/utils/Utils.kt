package ru.skillbranch.devintensive.utils

object Utils {

    private val CHAR_MAPPING = mapOf(
        'д' to "d",
        'е' to "e",
        'ё' to "e",
        'ж' to "zh",
        'з' to "z",
        'и' to "i",
        'й' to "i",
        'к' to "k",
        'л' to "l",
        'м' to "m",
        'н' to "n",
        'о' to "o",
        'п' to "p",
        'р' to "r",
        'с' to "s",
        'т' to "t",
        'у' to "u",
        'ф' to "f",
        'х' to "h",
        'ц' to "c",
        'ч' to "ch",
        'ш' to "sh",
        'щ' to "sh'",
        'ъ' to "",
        'ы' to "i",
        'ь' to "",
        'э' to "e",
        'ю' to "yu",
        'я' to "ya"
    )

    /**
     * Распознавание имени
     */
    fun parseFullName(fullName: String?): Pair<String?, String?> =
        if (fullName.isNullOrBlank() || fullName.isEmpty()) {
            Pair(null, null)
        } else {
            val names = fullName.trim().split(Regex("\\s+"))
            if (names.size < 3) Pair(names[0], names.getOrNull(1))
            else Pair(names[0], names.subList(1, names.size).joinToString(separator = " "))
        }

    /**
     * Преобразование в инициалы
     */
    fun toInitials(firstName: String?, lastName: String?): String? {
        val first = firstName?.get(0)?.toUpperCase()?.toString()
        val last = lastName?.get(0)?.toUpperCase()?.toString()
        return if (first != null)
            first + (last ?: "")
        else last
    }

    /**
     * Транслитерация
     *
     * @param payload String - полезная нагрузка
     * @param divider String - символ-разделитель
     */
    fun transliteration(payload: String, divider: String = " "): String {
        val buffer = StringBuffer()
        payload.asSequence().map { char ->
            val upper = char.isUpperCase()
            val sign = CHAR_MAPPING[char.toLowerCase()] ?: char.toString()
            if (upper) {
                sign.capitalize()
            } else sign
        }.forEach { buffer.append(it) }
        return buffer.toString().replace(Regex("\\s"), divider)
    }
}