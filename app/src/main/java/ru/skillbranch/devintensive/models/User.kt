package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

/**
 * Пользователь
 */
data class User(
    val id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar: String?,
    var rating: Int = 0,
    var respect: Int = 0,
    var lastVisit: Date? = Date(),
    var isOnline: Boolean = false
) {

    /**
     * Фабрика
     */
    companion object UserFactory {
        private var lastId = 1L

        /**
         * Создание пользователя
         *
         * @param fullName - полное имя
         */
        fun makeUser(fullName: String): User {

            val namePair = Utils.parseFullName(fullName)
            return User(
                id = (++lastId).toString(),
                firstName = namePair.first,
                lastName = namePair.second,
                avatar = Utils.toInitials(namePair.first, namePair.second)
            )
        }
    }
}